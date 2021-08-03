package com.movie.MovieProject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieProjectApplication {
   
    static final Logger logger = Logger.getLogger(MovieProjectApplication.class);
    static String path = "E:\\Netbeans\\MovieProject\\src\\main\\java\\log4j.properties";
    
	public static void main(String[] args) {
                try{
                PropertyConfigurator.configure(path);  // configuring log4j properties manually
                logger.info("Application Started");
		SpringApplication.run(MovieProjectApplication.class, args); // Starting the project
                }catch(Exception e){
                    System.out.println(e);
                }
	}

}


