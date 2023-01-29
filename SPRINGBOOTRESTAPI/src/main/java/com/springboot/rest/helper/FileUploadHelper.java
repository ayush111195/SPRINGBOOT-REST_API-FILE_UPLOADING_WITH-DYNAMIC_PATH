package com.springboot.rest.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.weaver.patterns.IScope;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR = "C:\\Users\\ag945\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE"
			+ "\\SPRINGBOOTRESTAPI\\src\\main\\resources\\static\\image";

	public boolean upLoadeFile(MultipartFile file) {
		boolean f = false;

		try {

//			//READ-->>
//			InputStream inputStream = file.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read(data);
//
//			//WRITE--->>
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			
			            //2nd method--->>
			
			Files.copy(file.getInputStream(),Paths.get(UPLOAD_DIR+"//"+file.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING);
			
			
			
			f=true;  //boolean ki value true-->>
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return f;
	}
}
