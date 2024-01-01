package com.test;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Configuration
public class BookSearch{
	
	
	
	@Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }
	@Bean
    public RecommendationService recommendationService() {
        return new RecommendationService();
    }
}

@Component
class RecommendationService {
	
	@Autowired
    public BookRepository repository;
        
    public String recommendBook() {
        return repository.getBooks().get(0);
    }
}

@Component
class BookRepository {
	
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Book");
        books.add("Short book");
        books.add("Long book");
        
        return books;
    }
}