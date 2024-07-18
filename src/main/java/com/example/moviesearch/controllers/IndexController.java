package com.example.moviesearch.controllers;

import java.util.List;

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
  public String index() {
    return "index";
  }

  @ModelAttribute
  @GetMapping("/search")
  public String search(String keyword, Model model) {
    // String json = MovieApiClient.searchMovieByTitle("titanic", "9025dd4f");
    // MovieList ml = new MovieList();
    // ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
    // model.addAttribute("result", ml.toString());
    // model.addAttribute("size", ml.getSearch().size());
    return "search";
  }

  @RequestMapping(value = "/searchmovie", method = RequestMethod.POST)
  public String takeInput(@RequestParam("movie1") String movieTitle, Model model) {
    // ObjectMapper objectMapper = new ObjectMapper();
    String json = MovieApiClient.searchMovieByTitle(movieTitle, "9025dd4f");

    try {
      MovieList ml = new MovieList();
      ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
      List<Movie> returnthis = ml.getSearch();
      model.addAttribute("searchresult", returnthis);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "search"; // Name of your search results page
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
