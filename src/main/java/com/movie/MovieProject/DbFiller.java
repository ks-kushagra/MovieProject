/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.MovieProject;

import com.movie.MovieProject.Repository.MovieRepository;
import com.movie.MovieProject.Model.Movie;
import org.apache.log4j.*;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kushagra
 */

@Component
public class DbFiller implements CommandLineRunner { // this class will enter some data in database

    //create MovieRepository Instance so that we can use deleteAll() or save() functions
    //Singleton Design Patter using Constructor
    
    
    
    Logger logger = MovieProjectApplication.logger;
    private MovieRepository movieRepo;
    
    @Autowired
    public void DbFiller(MovieRepository movieRepo){
        this.movieRepo = movieRepo;
    }
    
    @Override
    public void run(String... args) throws Exception {
         //create some instances
         
         Movie Godzilla2 = new Movie(1,"Godzilla2","Sci-Fi" , 9.4f);
         Movie ShutterIsland = new Movie(2,"Shutter Island" , "Mystery" , 8.3f);
         Movie IronMan = new Movie(3,"Iron Man" , "Action" , 8.9f);
         
         //delete DB if already present --> optional
         movieRepo.deleteAll();
         
         
         //Add all movie to our Database
         List <Movie> movie = Arrays.asList(Godzilla2 , ShutterIsland , IronMan);
         logger.info("Database Instantiated");
         movieRepo.saveAll(movie); // to save all movies
         
         
         
    }
    
}
