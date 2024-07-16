package com.example.moviesearch.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDetail {
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

    @SerializedName("Rated")
    private String Rated;

    @SerializedName("Released")
    private String Released;

    @SerializedName("Runtime")
    private String Runtime;

    @SerializedName("Genre")
    private String Genre;

    @SerializedName("Director")
    private String Director;

    @SerializedName("Writer")
    private String Writer;

    @SerializedName("Actors")
    private String Actors;

    @SerializedName("Plot")
    private String Plot;

    @SerializedName("Language")
    private String Language;

    @SerializedName("Country")
    private String Country;

    @SerializedName("Awards")
    private String Awards;

    @SerializedName("Ratings")
    private List<Rating> Ratings;

    @SerializedName("Metascore")
    private String Metascore;

    @SerializedName("imdbRating")
    private String imdbRating;

    @SerializedName("imdbVotes")
    private String imdbVotes;

    @SerializedName("BoxOffice")
    private String BoxOffice;

    @SerializedName("Production")
    private String Production;

    @SerializedName("Website")
    private String Website;
}
