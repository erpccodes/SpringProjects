package boot.fileUploard.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileDetailsHandler {

	  private final ResourcePatternResolver resourcePatternResolver;

	    @Value("${file.upload-dir}")
	    private String uploadDir;

	    public FileDetailsHandler(ResourcePatternResolver resourcePatternResolver) {
	        this.resourcePatternResolver = resourcePatternResolver;
	    }

	    @GetMapping("/files")
	    public ResponseEntity<List<String>> getAllFiles() {
	        try {
	            // Create the directory if it doesn't exist
	            File directory = new File(uploadDir);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            Resource[] resources = resourcePatternResolver.getResources("file:" + uploadDir + "/*");
	            List<String> fileNames = Arrays.stream(resources)
	                    .map(resource -> resource.getFilename())
	                    .collect(Collectors.toList());
	            return ResponseEntity.ok().body(fileNames);
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	    }
	    
}
