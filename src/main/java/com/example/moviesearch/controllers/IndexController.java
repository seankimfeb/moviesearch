package com.example.moviesearch.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.entity.Movie;
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

  @PostMapping("/searchmovie")
  @ResponseBody
  public ResponseEntity<List<Movie>> takeInput(@RequestParam("movie1") String movieTitle) {
    ObjectMapper objectMapper = new ObjectMapper();
    String json = MovieApiClient.searchMovieByTitle(movieTitle, "9025dd4f");

    try {
      MovieList ml = new MovieList();
      ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
      List<Movie> returnthis = ml.getSearch();

      return ResponseEntity.ok(returnthis);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(500).body(null);
    }
  }
}
