
package com.movie.MovieProject;

import com.movie.MovieProject.Repository.MovieRepository;
import com.movie.MovieProject.Model.Movie;
import org.apache.log4j.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Movie")
public class MovieController {
    private MovieRepository MovieRepo;
    Logger logger = MovieProjectApplication.logger;
    
    @Autowired        
    public void MovieController(MovieRepository MovieRepo){    // Dependency Injection using Constructor
        this.MovieRepo= MovieRepo;
    }
    
    @GetMapping("/all")
    public List<Movie> getAll(){    // fetch All movies
       List <Movie> movies = null;
        try{
        movies = MovieRepo.findAll();
        }catch(Exception e){
            System.out.println(e);
        }
       // logger.info("returned all Movies present in database");
        return movies;
    }
    
   
    @GetMapping("/{Name}")       // finding movie with name
    public Movie getbyName(@PathVariable("Name") String Name){
        List <Movie> movies = getAll();
        logger.info("User Requested for movie :" + Name);
        for(int i=0;i<movies.size();i++){
            if(movies.get(i).getName().equals(Name)){
                
                logger.info("Movie Found : " + Name);
                return movies.get(i);
            }
        }
        
        logger.info("Movie Not Found : " + Name);
        return new Movie(0,"Movie not found","NA",0f);
    }
}
