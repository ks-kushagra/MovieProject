/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.MovieProject.Model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Kushagra
 */

@Document(collection = "movie")
public class Movie {
   
    private int Id;
    private String Name;
    private String Genre;
    private float Rating;

    public Movie(int Id, String Name, String Genre, float Rating) {
        this.Id = Id;
        this.Name = Name;
        this.Genre = Genre;
        this.Rating = Rating;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getGenre() {
        return Genre;
    }

    public float getRating() {
        return Rating;
    }
    
    @Override
    public String toString(){
        return "[" + Id + " , " + Name + " , " + Genre + " , " + Rating + " ] ";
    }
}
