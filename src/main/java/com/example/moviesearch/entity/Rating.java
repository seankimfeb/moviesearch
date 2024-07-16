package com.example.moviesearch.entity;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    @SerializedName("Source")
    private String Source;

    @SerializedName("Value")
    private String Value;

    // Getters and setters can be added here
}
