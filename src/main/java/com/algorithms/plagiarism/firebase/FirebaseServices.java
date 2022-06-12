package com.algorithms.plagiarism.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class FirebaseServices {

    @EventListener
    public void init(ApplicationReadyEvent event) {
        try {
            ClassPathResource serviceAccount = new ClassPathResource("plagiarismchecker-d2959-firebase-adminsdk-fi25m-e53dc877d5.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                    .setProjectId(System.getenv("FIREBASE_PROJECT_ID"))
                    .setStorageBucket(System.getenv("FIREBASE_BUCKET_NAME"))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String saveMultipartFile(MultipartFile file, String fileName) throws IOException {
        Bucket storage = StorageClient.getInstance().bucket();
        Blob result = storage.create("originalFiles/" + fileName, file.getBytes(), file.getContentType());

        return result.getMediaLink();
    }

    public String saveTextFile(String content, String filename) {
        Bucket storage = StorageClient.getInstance().bucket();
        Blob result = storage.create("renderedFiles/" + filename + ".txt", content.getBytes(StandardCharsets.UTF_8));

        return result.getMediaLink();
    }
}
