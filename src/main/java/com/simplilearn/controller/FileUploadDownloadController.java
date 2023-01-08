package com.simplilearn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		// Save file internally somewhere
		File uploadedFile = new File("c://temp//" + file.getOriginalFilename());
		if (!uploadedFile.exists()) {
			uploadedFile.createNewFile();
		}

		FileOutputStream fout = new FileOutputStream(uploadedFile);
		fout.write(file.getBytes());
		fout.close();

		return "file is uploaded successfully";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) throws FileNotFoundException {
		File file = new File("c://temp//" + fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		// Prepare HTTP Headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "attachment; filename=downloaded1-" + fileName);
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.parseMediaType("application/txt"))
				.body(resource);
	}
}
