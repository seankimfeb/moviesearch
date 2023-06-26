package com.example.moviesearch.service;

import java.util.List;

import com.example.moviesearch.dto.MovieResponseDto;
import com.example.moviesearch.entity.Movie;

public interface UserService {
    List<Movie> searchMovie(MovieResponseDto dto);
    
}
