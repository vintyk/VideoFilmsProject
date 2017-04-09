package video;

import video.Entity.Movies;

import java.util.List;

import static video.dao.MovieDao.getMoviesByYear;

/**
 * Created by Vinty on 09.04.2017.
 */
public class MoviesStarter {
    public static void main(String[] args) {
        List<Movies> movies = getMoviesByYear(1994);
        movies.stream().forEach(System.out::println);
        //  addMovie("От заката до рассвета", 4, 1, "1992-01-01");
    }
}
