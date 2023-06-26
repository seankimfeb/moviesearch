package com.example.moviesearch.service.impl;

import java.util.List;
import java.util.Map;

import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.dto.MovieResponseDto;
import com.example.moviesearch.entity.Movie;
import com.google.gson.Gson;

public class UserServiceImpl {
    //List<Movie> searchMovie(MovieResponseDto dto){

    //}


    private static Movie extractMovieFromJson(String content){
        
        String title;
        Integer year;
        String imdbID;
        String type;
        String poster;
        Gson gson = new Gson();
       // Map jsonJavaRootObject = new Gson().fromJson(content, Map.class);
        //    System.out.println(jsonJavaRootObject.get("Title"));
        Movie movieResult = gson.fromJson(content,Movie.class);
        return movieResult;
    }
    public static void main(String[] args) {
        String parasite = (MovieApiClient.searchMovieByTitle("Aqua Teen Hunger Force Colon","9025dd4f"));
    System.out.println(parasite);
    System.out.println("Extracted:\n");
    Movie movie = extractMovieFromJson(parasite);
    System.out.println(movie.getTitle());
    }
    
}
