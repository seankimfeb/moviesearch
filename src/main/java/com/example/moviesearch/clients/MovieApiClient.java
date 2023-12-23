package com.example.moviesearch.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.example.moviesearch.dto.MovieResponseDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MovieApiClient {

    public static String sendGetRequest(String requestUrl) {
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                response.append(line);
            }
            buffer.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public static String searchMovieByTitle(String title, String key) {
        try {
            title = URLEncoder.encode(title, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String requestUrl = "http://www.omdbapi.com/?s=TITLE&apikey=APIKEY".replaceAll("TITLE", title)
                .replaceAll("APIKEY", key);
        return sendGetRequest(requestUrl);
    }

    /**
     * private final RestTemplate restTemplate;
     * private final String omdb_getMovies =
     * "http://www.omdbapi.com/?s=TITLE&apikey=APIKEY";
     * private
     * public MovieResponseDto requestMovie(String title,String key) {
     * //final HttpHeaders headers = new HttpHeaders(); // 헤더에 key들을 담아준다.
     * //headers.set("X-Naver-Client-Id", CLIENT_ID);
     * //headers.set("X-Naver-Client-Secret", CLIENT_SECRET);
     * String requestURL = omdb_getMovies.replaceAll("TITLE",
     * title).replaceAll("APIKEY", key);
     * //create http entity
     * //final HttpEntity<String> entity = new HttpEntity<>(headers);
     * 
     * return restTemplate.exchange(omdb_getMovies, HttpMethod.GET, entity,
     * MovieResponseDto.class, keyword).getBody();
     * }
     **/
    public static void main(String[] args) {
        System.out.println("HELLO");
        System.out.println(searchMovieByTitle("parasite", "9025dd4f"));
        Gson gson = new Gson();
        String json = searchMovieByTitle("parasite", "9025dd4f");
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        JsonArray searchResults = jsonObject.getAsJsonArray("Search");
        for (int i = 0; i < searchResults.size(); i++) {
            JsonObject result = searchResults.get(i).getAsJsonObject();
            String Title = result.get("Title").getAsString();
            String Year = result.get("Year").getAsString();
            String imdbID = result.get("imdbID").getAsString();
            String Type = result.get("Type").getAsString();
            String Poster = result.get("Poster").getAsString();

            // System.out.println("Title: " + title);
            // System.out.println("Year: " + year);
            // System.out.println("imdbID: " + imdbID);
            // System.out.println("Type: " + type);
            // System.out.println("Poster: " + poster);
            // System.out.println("---------------------");
        }
    }
}
