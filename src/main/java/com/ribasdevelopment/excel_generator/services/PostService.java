package com.ribasdevelopment.excel_generator.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ribasdevelopment.excel_generator.models.Post;

@Service
public class PostService {
	
	@Autowired
	private ExcelService excelService;
	

	public List<Post> getAll() {
		var restTemplate = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		String response = restTemplate.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		
		List<Post> posts  = new ArrayList<Post>();
		try {
			posts = mapper.readValue(response, new TypeReference<List<Post>>() {});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return posts;
	}
	
	public ByteArrayInputStream getPostsExcel() throws IOException {
		var posts = getAll();
		return excelService.createExcel(posts);
	}
}
