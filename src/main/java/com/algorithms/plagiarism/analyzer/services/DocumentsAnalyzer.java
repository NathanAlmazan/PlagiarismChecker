package com.algorithms.plagiarism.analyzer.services;

import com.algorithms.plagiarism.analyzer.cosine.CosineDistance;
import com.algorithms.plagiarism.analyzer.models.FileStorage;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

@Getter
public class DocumentsAnalyzer {
    private FileStorage mostSimilarDoc;

    public DocumentsAnalyzer(List<FileStorage> files, FileStorage source) throws IOException, ExecutionException, InterruptedException {
        FileExtractor extractor = new FileExtractor(source.getRenderedFileLink());
        String sourceText = extractor.getPdfText();
        int size = files.size();
        int half = size / 2;

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<FileStorage> getHighestDistance1 = () -> getHighestCosineDistance(sourceText, files, 0, half);
        Callable<FileStorage> getHighestDistance2 = () -> getHighestCosineDistance(sourceText, files, half, size);

        Future<FileStorage> highestDistance1 = executor.submit(getHighestDistance1);
        Future<FileStorage> highestDistance2 = executor.submit(getHighestDistance2);
        executor.shutdown();

        FileStorage result1 = highestDistance1.get();
        FileStorage result2 = highestDistance2.get();

        if (result1.getOriginalityScore() > result2.getOriginalityScore()) mostSimilarDoc = result1;
        else mostSimilarDoc = result2;
    }

    private FileStorage getHighestCosineDistance(String source, List<FileStorage> files, int start, int end) throws IOException {
        FileStorage highestDistance = new FileStorage();
        highestDistance.setOriginalityScore(0);

        for (int j = start; j < end; j++) {
            FileStorage current = files.get(j);
            FileExtractor extractor = new FileExtractor(current.getRenderedFileLink());

            CosineDistance cosineDistance = new CosineDistance(source, extractor.getPdfText(), false);
            double score = cosineDistance.getCosineDistance();

            if (score > highestDistance.getOriginalityScore()) {
                highestDistance = current;
                highestDistance.setOriginalityScore(score);
            }
        }

        return highestDistance;
    }


}
