package boot.fileUploard.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import org.springframework.util.StringUtils;

@Controller
public class FileUploadController {
	
	  @Value("${file.upload-dir}")
	    private String uploadDir;

	    @PostMapping("/upload")
	    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	        if (file.isEmpty()) {
	            return ResponseEntity.badRequest().body("Please select a file to upload.");
	        }

	        if (file.getSize() > 3 * 1024 * 1024) {
	            return ResponseEntity.badRequest().body("File size exceeds the maximum limit of 3 MB.");
	        }

	        try {
	            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	            // Create the directory if it doesn't exist
	            File directory = new File(uploadDir);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            File destFile = new File(directory, fileName);
	            file.transferTo(destFile);
	            return ResponseEntity.ok().body("File uploaded successfully!");
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file.");
	        }
	    }
}
