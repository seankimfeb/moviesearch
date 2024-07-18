package com.example.moviesearch.controllers;

import java.util.List;

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
  public String index() {
    return "index";
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
