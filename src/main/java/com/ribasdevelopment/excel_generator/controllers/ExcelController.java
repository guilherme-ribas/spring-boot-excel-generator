package com.ribasdevelopment.excel_generator.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ribasdevelopment.excel_generator.models.Post;
import com.ribasdevelopment.excel_generator.services.PostService;
 
@RestController()
@RequestMapping("/post")
public class ExcelController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> getAll() {
		return postService.getAll();
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]> getExcel() throws IOException {
		ByteArrayInputStream body = postService.getPostsExcel();
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=pessoas.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(body.readAllBytes());

	}

}
