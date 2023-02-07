package com.example.My_First_App;

import com.example.My_First_App.Model.Books;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//import java.awt.print.Book;
//import java.io.File;

//@SpringBootApplication
public class MyFirstAppApplication {

	public static void main(String[] args) throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl
				= "https://simple-books-api.glitch.me/books";
		ResponseEntity <String> response
				= restTemplate.getForEntity(resourceUrl,String.class);
		String output = response.getBody();
// converting json to jv
		ObjectMapper mapper = new ObjectMapper();
		Books[] books = mapper.readValue(output, Books[].class);

		for(Books book:books){
			System.out.println(book.toString());
		}

//		converting jv to json

//		mapper.writeValue(new File(pathname:), output);


//		SpringApplication.run(MyFirstAppApplication.class, args);
	}

}
