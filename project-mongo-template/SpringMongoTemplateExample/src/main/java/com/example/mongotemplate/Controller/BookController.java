/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mongotemplate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.example.mongotemplate.Model.Book;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@Component
public class BookController implements CommandLineRunner{

    @Autowired
    private MongoTemplate mongoTemplate;
    
    
    @Override
    public void run(String... args) throws Exception {
       //save()
        mongoTemplate.save(new Book(1, "Core Java", 200, "Kathy Sierra", 1065.5) , "Bookss");
        mongoTemplate.save((new Book(2,"Cingage",1000,"Cingage",900.32) ) , "Books");
        
        
        //using insert
        Book java = new Book(3,"Java Core" ,1000,"Someone",986);
        Book C = new Book(4 , "C",300,"Unknown",234);
        
        mongoTemplate.insert(Arrays.asList(java,C) , "Books");
        
      
        //find
      List <Book> allBooks = mongoTemplate.findAll(Book.class);
      System.out.println(allBooks);
      
      //findById
      Book book = mongoTemplate.findById(1, Book.class, "Books");
        
      
      //findByName
    Query query = new Query();
    query.addCriteria(Criteria.where("Name").is("Core Java"));
    System.out.println( mongoTemplate.findOne(query, Book.class));
    }
    
}
