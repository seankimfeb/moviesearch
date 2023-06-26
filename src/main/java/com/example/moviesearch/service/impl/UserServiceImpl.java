package com.example.moviesearch.service.impl;

import java.util.List;
import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.entity.Movie;
import com.example.moviesearch.entity.MovieList;
import com.google.gson.Gson;

public class UserServiceImpl {
    //List<Movie> searchMovie(MovieResponseDto dto){

    //}


    private static List<Movie> extractMovieFromJson(String content){
        
        /** 
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(content, JsonObject.class);

        JsonArray searchResults = jsonObject.getAsJsonArray("Search");
        for (int i = 0; i < searchResults.size(); i++) {
            JsonObject result = searchResults.get(i).getAsJsonObject();
            String title = result.get("Title").getAsString();
            String year = result.get("Year").getAsString();
            String imdbID = result.get("imdbID").getAsString();
            String type = result.get("Type").getAsString();
            String poster = result.get("Poster").getAsString();

           
        }
        return searchResults;
        **/

        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(content, MovieList.class);
        List<Movie> movies = movieList.getSearch();
        //System.out.println("Size = "+ movies.size());
        //for (Movie movie : movies) {
        //    System.out.println("Title: " + movie.getTitle());
        //    System.out.println("Year: " + movie.getYear());
        //    System.out.println("imdbID: " + movie.getImdbID());
        //    System.out.println("Type: " + movie.getType());
        //    System.out.println("Poster: " + movie.getPoster());
        //    System.out.println("---------------------");
       // }
        return movies;

    }
    public static void main(String[] args) {
    String parasite = (MovieApiClient.searchMovieByTitle("parasite","9025dd4f"));
    System.out.println("Extracted:\n");
    List<Movie> movies = extractMovieFromJson(parasite);
    System.out.println("Size = "+ movies.size());

    }
    
}
