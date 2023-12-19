package com.example.moviesearch.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moviesearch.clients.MovieApiClient;
import com.example.moviesearch.entity.MovieList;
import com.example.moviesearch.service.impl.UserServiceImpl;

@Controller
public class IndexController {

  @GetMapping
  public String index() {
    return "index";
  }

  /**
   * @ModelAttribute
   *                 @GetMapping("/search")
   *                 public String search(String keyword, Model model) {
   *                 String json = MovieApiClient.searchMovieByTitle("titanic",
   *                 "9025dd4f");
   *                 MovieList ml = new MovieList();
   *                 ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
   *                 model.addAttribute("result", ml.toString());
   *                 model.addAttribute("size", ml.getSearch().size());
   *                 return "search";
   *                 }
   */
  /**
   * @RequestMapping(value = "/search", method = RequestMethod.POST)
   *                       public String takeInput(@RequestParam("movie1") String
   *                       movieTitle, Model model) {
   *                       String json =
   *                       MovieApiClient.searchMovieByTitle(movieTitle,
   *                       "9025dd4f");
   *                       MovieList ml = new MovieList();
   *                       ml.setSearch(UserServiceImpl.extractMovieFromJson(json));
   *                       model.addAttribute("result", ml.toString());
   *                       model.addAttribute("size", ml.getSearch().size());
   *                       return "search";
   *                       }
   */
  @RequestMapping(value = "/search", method = RequestMethod.POST)
  public String takeInputv2(@RequestParam("movie1") String movieTitle, Model model) {
    String result = MovieApiClient.searchMovieByTitle(movieTitle, "9025dd4f");
    // MovieList ml = new MovieList();
    // ml.setSearch(UserServiceImpl.extractMovieFromJson(jsonresult));
    model.addAttribute("result", result);
    return "search";
  }
  // https://stackoverflow.com/questions/57744114/how-to-show-list-of-object-in-thymeleaf-in-spring-boot-project
  // https://strongstar.tistory.com/16
}
