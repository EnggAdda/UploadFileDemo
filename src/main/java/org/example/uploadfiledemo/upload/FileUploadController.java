package org.example.uploadfiledemo.upload;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file)  throws IOException {
        String uploadDir  = "uploads/";
        File directory = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }
        Path filePath = Paths.get(uploadDir + file.getOriginalFilename());
        Files.write(filePath,file.getBytes());
        return ResponseEntity.ok("file successfully uploaded and stored "+ file.getOriginalFilename());

    }
}
