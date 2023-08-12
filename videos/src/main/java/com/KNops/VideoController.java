package com.KNops;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            Video video = new Video();
            video.setName(file.getOriginalFilename());
            video.setContentType(file.getContentType());
            video.setData(file.getBytes());

            videoRepository.save(video);

            return ResponseEntity.ok("Video uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading video.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) {
        Optional<Video> videoOptional = videoRepository.findById(id);
        if (videoOptional.isPresent()) {
            Video video = videoOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(video.getContentType()))
                    .body(video.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
