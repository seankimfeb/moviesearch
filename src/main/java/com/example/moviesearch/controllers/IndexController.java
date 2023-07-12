package com.example.moviesearch.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.entity.MovieList;
import com.example.moviesearch.service.impl.UserServiceImpl;

@Controller
public class IndexController {
    
    @GetMapping
    public String index(){
		return "index";
	}
  @ModelAttribute
  @GetMapping("/search")
  public String search(String keyword, Model model){
    String json = MovieApiClient.searchMovieByTitle("titanic","9025dd4f");
    MovieList ml = new MovieList();
    ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
    model.addAttribute("result", ml.toString());
    return "search";
  }

}
