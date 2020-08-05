package com.diluna.com.demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.diluna.com.demo.model.Bookmark;
import com.diluna.com.demo.service.BookmarkServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	private static final String JSON_URL="http://demo.dreamsquadgroup.com/test/index.json ";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(BookmarkServiceImpl bookmarkService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			
			TypeReference<List<Bookmark>> typeReference=new TypeReference<List<Bookmark>>() {};
			//TypeReference<List<Bookmark>> typeReference = new TypeReference<List<Bookmark>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
			//URL inputStream = TypeReference.class.getResource(JSON_URL);
			try {
				List<Bookmark> bookmark = mapper.readValue(inputStream,typeReference);
				bookmarkService.saveAll(bookmark);
				System.out.println(bookmark);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
	
}
