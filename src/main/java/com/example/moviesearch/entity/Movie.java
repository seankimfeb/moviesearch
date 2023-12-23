package com.example.moviesearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @SerializedName("Title")
    private String Title;
    @SerializedName("Year")
    private String Year;
    @SerializedName("imdbID")
    private String imdbID;
    @SerializedName("Type")
    private String Type;
    @SerializedName("Poster")
    private String Poster;

    // {"Search":
    // [{"Title":"Parasite","Year":"2019","imdbID":"tt6751668","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg"},{"Title":"Parasite","Year":"1982","imdbID":"tt0084472","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTFlZDVjMDMtODkwNS00MTM3LWJiMzQtY2IxN2JiNWZjMWUxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"}

}
