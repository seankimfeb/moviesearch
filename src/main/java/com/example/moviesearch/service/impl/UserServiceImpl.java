package com.example.moviesearch.service.impl;

import java.util.List;
import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.entity.Movie;
import com.example.moviesearch.entity.MovieDetail;
import com.example.moviesearch.entity.MovieList;
import com.google.gson.Gson;

public class UserServiceImpl {

    public static List<Movie> extractMovieFromJson(String content) {

        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(content, MovieList.class);
        List<Movie> movies = movieList.getSearch();

        return movies;

    }

    public static MovieDetail extractDetailFromJson(String content) {
        Gson gson = new Gson();
        MovieDetail md = gson.fromJson(content, MovieDetail.class);
        return md;

    }

    // test here
    public static void main(String[] args) {
        // String parasite = (MovieApiClient.searchMovieByTitle("parasite",
        // "9025dd4f"));
        // System.out.println("Extracted:\n");
        // List<Movie> movies = extractMovieFromJson(parasite);
        // System.out.println(movies.toString());
        // System.out.println("Size = " + movies.size());
        // String avengers = (MovieApiClient.GetMovieDetail("tt0848228", "9025dd4f"));
        // System.out.println(avengers);
        // MovieDetail moviedetail = extractDetailFromJson(avengers);
        // System.out.println(moviedetail.getAwards());
    }

}
