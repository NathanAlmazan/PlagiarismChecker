package com.algorithms.plagiarism.analyzer.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;

@Getter
@NoArgsConstructor
public class FileExtractor {
    private String pdfText;

    public FileExtractor(final String urlSource) throws IOException {
        URL url = new URL(urlSource);
        BufferedReader readFile = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder sb = new StringBuilder();
        String i;

        while ((i = readFile.readLine()) != null) sb.append(i);
        readFile.close();

        pdfText = sb.toString();
    }

    public FileExtractor(final MultipartFile pdfFile) throws IOException {
        final PDDocument document = PDDocument.load(pdfFile.getInputStream());
        final PDFTextStripper stripPDF = new PDFTextStripper();
        stripPDF.setLineSeparator(" ");
        pdfText = stripPDF.getText(document);
        document.close();
    }

    public String getPlainContent(final MultipartFile pdfFile) throws IOException {
        final PDDocument document = PDDocument.load(pdfFile.getInputStream());
        final PDFTextStripper stripPDF = new PDFTextStripper();
        String plainText = stripPDF.getText(document);
        document.close();

        return plainText;
    }

    public LinkedList<String> tokenizeText() {
        LinkedList<Character> word = new LinkedList<>();
        LinkedList<String> cleanedText = new LinkedList<>();

        TextCleaner stopWords = new TextCleaner();

        for (int i = 0; i < pdfText.length(); i++) {
            char c = pdfText.charAt(i);

            // Add to word to tokens after a space
            if (c == '.' && pdfText.charAt(i+1) == ' ') {
                String current = getStringRepresentation(word);

                // Check the length of word
                if (current.length() > 2 && !stopWords.searchStopWord(current)) {
                    cleanedText.add(current);
                }
                cleanedText.add("%");
                word.clear();
            }
            else if (c == ' ') {
                String current = getStringRepresentation(word);

                // Check the length of word
                if (current.length() > 2 && !stopWords.searchStopWord(current)) {
                    cleanedText.add(current);
                }
                word.clear();
            }
            // Add lowercase character to word if it is a letter
            else if (Character.isLetter(c)) word.add(Character.toLowerCase(c));
        }

        // Process word left
        if (word.size() > 0) {
            String current = getStringRepresentation(word);

            // Check the length of word
            if (current.length() > 2 && !stopWords.searchStopWord(current)) {
                cleanedText.add(current);
            }
            word.clear();
        }

        return cleanedText;
    }

    private String getStringRepresentation(LinkedList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
}

