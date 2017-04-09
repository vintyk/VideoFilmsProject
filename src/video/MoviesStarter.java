package video;

import video.Entity.Movies;
import video.dao.MovieDao;

import java.util.List;
import java.util.Optional;

import static video.dao.MovieDao.getMoviesByYear;

/**
 * Created by Vinty on 09.04.2017.
 */
public class MoviesStarter {
    public static void main(String[] args) {

        Optional<Movies> moviesOptional
                = MovieDao.getInstance().save(new Movies("Джанго освобожденный", 4, 1, "2015.01.01"));
        if (moviesOptional.isPresent()) {
            System.out.println(moviesOptional.get());
        }

        List<Movies> movies = getMoviesByYear(1994);
        movies.stream().forEach(System.out::println);

        //  addMovie("От заката до рассвета", 4, 1, "1992-01-01");
    }
}
