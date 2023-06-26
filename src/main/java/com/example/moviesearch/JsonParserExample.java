package com.example.moviesearch;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class JsonParserExample {
    
    public static void main(String[] args) {
        String json = "{\"Search\":[{\"Title\":\"Parasite\",\"Year\":\"2019\",\"imdbID\":\"tt6751668\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_SX300.jpg\"},{\"Title\":\"Parasite\",\"Year\":\"1982\",\"imdbID\":\"tt0084472\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTFlZDVjMDMtODkwNS00MTM3LWJiMzQtY2IxN2JiNWZjMWUxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"},{\"Title\":\"Parasite Eve\",\"Year\":\"1997\",\"imdbID\":\"tt0119860\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BODhmMWIyM2MtNDBhOS00YmZkLWJjNDItZDViYTRhZGU3OGE4XkEyXkFqcGdeQXVyNzc5MjA3OA@@._V1_SX300.jpg\"},{\"Title\":\"Parasite Dolls\",\"Year\":\"2003\",\"imdbID\":\"tt0376058\",\"Type\":\"series\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNTgwNTBhYjMtZjVkNS00YTExLWE2ZWYtOTMyODRlMjkwMmJjXkEyXkFqcGdeQXVyNzc5MjA3OA@@._V1_SX300.jpg\"},{\"Title\":\"Sexual Parasite: Killer Pussy\",\"Year\":\"2004\",\"imdbID\":\"tt0434125\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTY3MjE0MTA3Nl5BMl5BanBnXkFtZTcwNTE0MjE2MQ@@._V1_SX300.jpg\"},{\"Title\":\"Parasite\",\"Year\":\"2004\",\"imdbID\":\"tt0352699\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzY1NTA4MDQ4Nl5BMl5BanBnXkFtZTcwNzMyMTUxMQ@@._V1_SX300.jpg\"},{\"Title\":\"Parasite Eve\",\"Year\":\"1998\",\"imdbID\":\"tt0261889\",\"Type\":\"game\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYzZiZmVlNzQtMmVlYy00OTBlLTk4NGItMWJhOTk2OWIxOTI1XkEyXkFqcGdeQXVyOTQxNzM2MjY@._V1_SX300.jpg\"},{\"Title\":\"Parasite Eve II\",\"Year\":\"1999\",\"imdbID\":\"tt0262673\",\"Type\":\"game\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYWQ2OGVmNWQtOTIwMS00MWE5LTk5NTktMTE2YjIzMGJhZWEyXkEyXkFqcGdeQXVyOTQxNzM2MjY@._V1_SX300.jpg\"},{\"Title\":\"Parasite in Love\",\"Year\":\"2021\",\"imdbID\":\"tt16059146\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOTNlM2RmNzctOGQ1Mi00MjYyLWJhOGMtNGIwNmJlNGM5MzUzXkEyXkFqcGdeQXVyNjE4OTY3NTg@._V1_SX300.jpg\"},{\"Title\":\"The Parasite Doctor Suzune: Genesis\",\"Year\":\"2011\",\"imdbID\":\"tt2047769\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjIxMDU2MTA2N15BMl5BanBnXkFtZTgwOTM3MTAwMTE@._V1_SX300.jpg\"}],\"totalResults\":\"68\",\"Response\":\"True\"}";

        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(json, MovieList.class);

        List<Movie> movies = movieList.getSearch();
    System.out.println("Size = "+ movies.size());
        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Year: " + movie.getYear());
            System.out.println("imdbID: " + movie.getImdbID());
            System.out.println("Type: " + movie.getType());
            System.out.println("Poster: " + movie.getPoster());
            System.out.println("---------------------");
        }
    }

    static class Movie {
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

        // Getters and Setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }
    }

    static class MovieList {
        @SerializedName("Search")
        private List<Movie> search;

        // Getter and Setter

        public List<Movie> getSearch() {
            return search;
        }

        public void setSearch(List<Movie> search) {
            this.search = search;
        }
    }
}
