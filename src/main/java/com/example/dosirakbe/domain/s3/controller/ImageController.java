package com.example.dosirakbe.domain.s3.controller;

import com.example.dosirakbe.global.config.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageController {

    private final S3Uploader s3Uploader;

    @PostMapping("/upload-multiple")
    public ResponseEntity<List<String>> uploadMultipleImages(@RequestParam("files") List<MultipartFile> files) {
        List<String> uploadedUrls = s3Uploader.saveFiles(files);
        return new ResponseEntity<>(uploadedUrls, HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadSingleImage(@RequestParam("file") MultipartFile file) {

        String uploadedUrl = s3Uploader.saveFile(file);
        return new ResponseEntity<>(uploadedUrl, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteImage(@RequestParam("url") String fileUrl) {

        s3Uploader.deleteFile(fileUrl);
        return new ResponseEntity<>("Image deleted successfully.", HttpStatus.OK);
    }
}
