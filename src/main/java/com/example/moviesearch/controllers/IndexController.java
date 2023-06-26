package com.example.moviesearch.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.moviesearch.entity.MovieList;
import com.example.moviesearch.service.impl.UserServiceImpl;

@Controller
public class IndexController {
    
    @GetMapping
    public String index(){
		return "index";
	}
  @GetMapping("/search")
  public MovieList search(String keyword){
    MovieList ml = new MovieList();
    ml.setSearch(UserServiceImpl.extractMovieFromJson(keyword));
    return ml;
  }

}
