package com.example.moviesearch.entity;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
   @SerializedName("Title")
        private String title;
        @SerializedName("Year")
        private String year;
        @SerializedName("imdbID")
        private String imdbID;
        @SerializedName("Type")
        private String type;
        @SerializedName("Poster")
        private String poster;
    
//{"Search":
//[{"Title":"Parasite","Year":"2019","imdbID":"tt6751668","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg"},{"Title":"Parasite","Year":"1982","imdbID":"tt0084472","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTFlZDVjMDMtODkwNS00MTM3LWJiMzQtY2IxN2JiNWZjMWUxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"}
    
}
