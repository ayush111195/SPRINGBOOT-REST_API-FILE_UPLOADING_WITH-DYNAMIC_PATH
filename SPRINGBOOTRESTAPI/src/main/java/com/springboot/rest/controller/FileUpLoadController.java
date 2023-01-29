package com.springboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.helper.FileUploadHelper;

@RestController
public class FileUpLoadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFilr(@RequestParam ("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());

		 try {
        if(file.isEmpty()) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request_Must_Contain_file");
        }
		
        //File upload code--->>>
        
     boolean f=   fileUploadHelper.upLoadeFile(file);
       
        	if(f) {
        		//return ResponseEntity.ok("FileIs Successfully Uploaded");
        		
        		//to find the uri of image--->>
        		return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().
        				path("/image").path(file.getOriginalFilename()).toUriString());
        	}
		} catch (Exception e) {
       e.printStackTrace();	}
        
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing Went Worng Try Again");
		
	}
}
