package com.example.moviesearch.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.entity.Movie;
import com.example.moviesearch.entity.MovieDetail;
import com.example.moviesearch.entity.MovieList;
import com.example.moviesearch.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@Controller
public class IndexController {

  @GetMapping
  public String index(Model model) {
    List<MovieDetail> randomMovies = getRandomMovies(5);
    model.addAttribute("randomMovies", randomMovies);
    return "index";
  }

  // set of predefined imdb id to present
  private List<String> validImdbIds = Arrays.asList(
      "tt0111161", "tt0068646", "tt0071562", "tt0468569", "tt0050083",
      "tt0108052", "tt0167260", "tt0110912", "tt0060196", "tt0137523", "tt0848228"
  // Add more valid IMDb IDs here
  );

  private List<MovieDetail> getRandomMovies(int count) {
    List<MovieDetail> randomMovies = new ArrayList<>();
    // Random random = new Random();

    Collections.shuffle(validImdbIds); // Shuffle the list to get random movies

    for (int i = 0; i < count; i++) {
      String imdbID = validImdbIds.get(i); // Get a valid IMDb ID from the list
      String json = MovieApiClient.GetMovieDetail(imdbID, "9025dd4f");

      try {
        MovieDetail movie = UserServiceImpl.extractDetailFromJson(json);
        randomMovies.add(movie);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return randomMovies;
  }

  @PostMapping("/searchmovie")
  public String takeInput(HttpServletRequest request, Model model) {
    String movieTitle = request.getParameter("movie1");
    String json = MovieApiClient.searchMovieByTitle(movieTitle, "9025dd4f");

    try {
      MovieList ml = new MovieList();
      ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
      List<Movie> returnthis = ml.getSearch();
      model.addAttribute("searchresult", returnthis); // transfer object to the html
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "search";
  }

  @GetMapping("/moviedetail")
  public String movieDetail(@RequestParam("id") String imdbID, Model model) {
    try {
      String json = MovieApiClient.GetMovieDetail(imdbID, "9025dd4f");
      MovieDetail movieDetail = UserServiceImpl.extractDetailFromJson(json);

      model.addAttribute("movieDetail", movieDetail);
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", "Error fetching movie details");
      return "error"; // Handle error properly
    }
    return "moviedetail"; // Return the Thymeleaf template, it will automatically search for "moviedetail"
  }

}
