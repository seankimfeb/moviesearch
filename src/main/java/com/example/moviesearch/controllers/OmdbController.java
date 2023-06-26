package com.example.moviesearch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviesearch.clients.MovieApiClient;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
public class OmdbController {

   // @GetMapping("/?s={keyword}")
    // public MoviesResponseDto get(@PathVariable String keyword){
     //   return MovieApiClient.searchMovieByTitle(keyword,"9025dd4f");
   // }
}
