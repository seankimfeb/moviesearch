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

    public String toString() {
        String result = "";
        for (int i = 0; i < search.size(); i++) {
            Movie currentItem = search.get(i);
            result = result + currentItem.getTitle() + "\n" + "(" + currentItem.getYear() + ")" + "\n";
        }
        return result;
    }

}
