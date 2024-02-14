package com.BookStore.Books;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
public class BooksApplication {

	public static void main(String[] args) {


		try {
			ObjectMapper mapper = new XmlMapper();

			FileInputStream inputStream = new FileInputStream(new File("D://Books//src//main//java//com//BookStore//Books//Books.xml"));
			TypeReference<List<book1>> typeReference = new TypeReference<List<book1>>() {};
			List<book1> booksList = mapper.readValue(inputStream, typeReference);
			inputStream.close();
			for(book1 abc:booksList)
			{
			System.out.println(abc.getTitle());
				abc.Database();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

