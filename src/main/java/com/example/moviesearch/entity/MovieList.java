package com.example.moviesearch.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @JsonIgnoreProperties(ignoreUnknown = true)
public class MovieList {
    @SerializedName("Search")
    private List<Movie> search;

    public String toString() {
        String result = "";
        for (int i = 0; i < search.size(); i++) {
            Movie currentItem = search.get(i);
            result = result + currentItem.getTitle() + "\n" + currentItem.getYear() + "\n";
        }
        return result;
    }

    public int getSize() {
        return search.size();
    }
}
