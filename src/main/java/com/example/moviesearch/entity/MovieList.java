package com.example.moviesearch.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieList {
    @SerializedName("Search")
    private List<Movie> search;
}
