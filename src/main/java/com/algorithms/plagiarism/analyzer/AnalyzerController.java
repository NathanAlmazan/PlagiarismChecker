package com.algorithms.plagiarism.analyzer;

import com.algorithms.plagiarism.analyzer.cosine.CosineDistance;
import com.algorithms.plagiarism.analyzer.models.*;
import com.algorithms.plagiarism.analyzer.services.DocumentsAnalyzer;
import com.algorithms.plagiarism.analyzer.services.FileExtractor;
import com.algorithms.plagiarism.analyzer.services.FileStorageCrud;
import com.algorithms.plagiarism.errors.types.FileConversionFailed;
import com.algorithms.plagiarism.errors.types.IncompleteArgumentsException;
import com.algorithms.plagiarism.errors.types.InternalErrorException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.algorithms.plagiarism.firebase.FirebaseServices;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api/v1/analyzer")
@RequiredArgsConstructor
@Validated
public class AnalyzerController {
    @Autowired private FirebaseServices firebaseServices;
    @Autowired private FileStorageCrud fileStorageCrud;

    @PostMapping(value = "/file/extract", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FileStorage> extractText(@Valid @NotNull @RequestParam("file") final MultipartFile pdfFile) {
        if (pdfFile.isEmpty()) throw new IncompleteArgumentsException("PDF file is required.");
        try {
            // Extract words in texts, clean, and tokenize
            FileExtractor extractor = new FileExtractor(pdfFile);
            String convertedText = String.join(">", extractor.tokenizeText());

            // Save file to Google Cloud
            ExecutorService executor = Executors.newFixedThreadPool(2);
            UUID fileUid = UUID.randomUUID();
            Callable<String> saveOriginalFile = () -> firebaseServices.saveMultipartFile(pdfFile, fileUid.toString());
            Callable<String> saveRenderedFile = () -> firebaseServices.saveTextFile(convertedText, fileUid.toString());

            Future<String> originalLink = executor.submit(saveOriginalFile);
            Future<String> renderedLink = executor.submit(saveRenderedFile);
            executor.shutdown();

            // Save file information in database
            FileStorage newFile = new FileStorage();
            newFile.setFileName(FilenameUtils.removeExtension(pdfFile.getOriginalFilename()));
            newFile.setFileUid(fileUid.toString());
            newFile.setOriginalFileLink(originalLink.get());
            newFile.setRenderedFileLink(renderedLink.get());

            return new ResponseEntity<>(fileStorageCrud.insertFile(newFile), HttpStatus.CREATED);
        } catch (IOException e) {
            throw new FileConversionFailed();
        } catch (ExecutionException | InterruptedException e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    @PostMapping("/compare")
    public ResponseEntity<ComparisonResponseBody> compareTwoDocument(@Valid @RequestBody ComparisonRequestBody body) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            // Extract document A into string of words
            Callable<String> tokenizeDocA = () -> {
                FileStorage result = fileStorageCrud.getFileById(body.getDocumentA());
                FileExtractor extractor = new FileExtractor(result.getRenderedFileLink());
                return extractor.getPdfText();
            };

            // Extract document B into string of words
            Callable<String> tokenizeDocB = () -> {
                FileStorage result = fileStorageCrud.getFileById(body.getDocumentB());
                FileExtractor extractor = new FileExtractor(result.getRenderedFileLink());
                return extractor.getPdfText();
            };

            Future<String> textA = executor.submit(tokenizeDocA);
            Future<String> textB = executor.submit(tokenizeDocB);
            executor.shutdown();

            // Compute the cosine distance
            CosineDistance cosineDistance = new CosineDistance(textA.get(), textB.get(), true);

            // Check of both document have exact the same sentences
            cosineDistance.setTextASentences(textA.get());
            cosineDistance.setTextBSentences(textB.get());

            // Create a response
            ComparisonResponseBody response = new ComparisonResponseBody();
            response.setCosineDistance(cosineDistance.getCosineDistance());
            response.setSimilarTerms(cosineDistance.getSimilarWords());
            response.setSentencesA(cosineDistance.getTextASentences());
            response.setSentencesB(cosineDistance.getTextBSentences());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ExecutionException | InterruptedException e) {
            throw new InternalErrorException(e.getMessage());
        }
    }

    @PostMapping("/analyze")
    public ResponseEntity<FileStorage> analyzeDocument(@Valid @RequestBody AnalyzerRequestBody body) {
        List<FileStorage> files = fileStorageCrud.getAllFilesWithException(body.getExcludeDocuments());
        FileStorage analyzedFile = fileStorageCrud.getFileById(body.getDocumentId());

        try {
            DocumentsAnalyzer analyzer = new DocumentsAnalyzer(files, analyzedFile);

            return new ResponseEntity<>(analyzer.getMostSimilarDoc(), HttpStatus.OK);
        } catch (IOException | ExecutionException | InterruptedException e) {
            throw new InternalErrorException(e.getMessage());
        }

    }

    @GetMapping("/file/delete/{fileId}")
    public ResponseEntity<PlainResponseDto> deleteFileById(@PathVariable("fileId") Long fileId) {
        fileStorageCrud.deleteFile(fileId);
        return new ResponseEntity<>(new PlainResponseDto(200, "Deleted Successfully."), HttpStatus.OK);
    }

    @GetMapping("/file/all")
    public ResponseEntity<List<FileStorage>> getAllFiles() {
        return new ResponseEntity<>(fileStorageCrud.getAllFiles(), HttpStatus.OK);
    }

    @PostMapping(value = "/file/content", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlainResponseDto> getFileContent(@Valid @NotNull @RequestParam("file") final MultipartFile pdfFile) {
        try {
            FileExtractor extractor = new FileExtractor();

            PlainResponseDto response = new PlainResponseDto();
            response.setMessage(extractor.getPlainContent(pdfFile));
            response.setStatus(200);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            throw new InternalErrorException(e.getMessage());
        }
    }
}
