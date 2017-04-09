package video.dao;

import video.Entity.Movies;
import video.Entity.People;
import video.connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinty on 09.04.2017.
 */
public class MovieDao {

    public static List<Movies> getMoviesByYear(int year) {
        List<Movies> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT movies.name,\n" +
                            "       Year(movies.year),\n" +
                            "       countries.name,\n" +
                            "       genres.name,\n" +
                            "       movies.id\n" +
                            "FROM (movies_project.movies movies\n" +
                            "      INNER JOIN movies_project.countries countries\n" +
                            "         ON (movies.countrie = countries.id))\n" +
                            "     INNER JOIN movies_project.genres genres ON (movies.genre = genres.id)\n" +
                            "    where year(movies.year) = ?\n" +
                            "ORDER BY movies.name ASC")) {
                preparedStatement.setInt(1, year);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while(resultSet.next()) {
                        long idMovie = resultSet.getLong("movies.id");
                        String nameMovie = resultSet.getString("movies.name");
                        String dateReleaseMovie = resultSet.getString("Year(movies.year)");
                        String genreMovie = resultSet.getString("genres.name");
                        String countryMovie = resultSet.getString("countries.name");
                        Movies movies = new Movies(idMovie, nameMovie, genreMovie, countryMovie, dateReleaseMovie);
                        result.add(movies);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Movies getMovieById(long movieId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT m.id,\n" +
                            "       m.name,\n" +
                            "       m.year,\n" +
                            "       g.name,\n" +
                            "       c.name,\n" +
                            "       r.name,\n" +
                            "       p.Id,\n" +
                            "       p.name,\n" +
                            "       p.family,\n" +
                            "       p.s_name,\n" +
                            "       p.date_bday\n" +
                            "FROM ((((movies_project.people AS p\n" +
                            "         INNER JOIN movies_project.roles AS r\n" +
                            "            ON (p.id_role = r.id))\n" +
                            "        INNER JOIN movies_project.movie_people_role movie_people_role\n" +
                            "           ON     (movie_people_role.id_role = r.id)\n" +
                            "              AND (movie_people_role.id_people = p.Id))\n" +
                            "       INNER JOIN movies_project.movies AS m\n" +
                            "          ON (movie_people_role.id_movie = m.id))\n" +
                            "      INNER JOIN movies_project.genres AS g\n" +
                            "         ON (m.genre = g.id))\n" +
                            "     INNER JOIN movies_project.countries AS c\n" +
                            "        ON (m.countrie = c.id)\n" +
                            "        WHERE m.id = ?\n" +
                            "ORDER BY m.id ASC, r.name DESC")) {
                preparedStatement.setLong(1, movieId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        long idMovie = resultSet.getLong("m.id");
                        String nameMovie = resultSet.getString("m.name");
                        String dateReleaseMovie = resultSet.getString("m.year");
                        String genreMovie = resultSet.getString("g.name");
                        String countryMovie = resultSet.getString("c.name");
                        String role = resultSet.getString("r.name");
                        long idPeople = resultSet.getLong("p.id");
                        String namePeople = resultSet.getString("p.name");
                        String familyPeople = resultSet.getString("p.family");
                        String sNamePeople = resultSet.getString("p.s_name");
                        String dateOfBirthPeople = resultSet.getString("p.date_bday");

                        People people = new People(idPeople,
                                namePeople,
                                familyPeople,
                                sNamePeople,
                                dateOfBirthPeople,
                                role);
                        return new Movies(idMovie,
                                nameMovie,
                                genreMovie,
                                countryMovie,
                                dateReleaseMovie,
                                people);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addMovie(String nameMovie,
                                 int genreMovie,
                                 int countryMovie,
                                 String dateReleaseMovie) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO movies (name, genre, countrie, year)" +
                            " VALUES (?, ?, ?, ?)")) {
                preparedStatement.setString(1, nameMovie);
                preparedStatement.setInt(2, genreMovie);
                preparedStatement.setInt(3, countryMovie);
                preparedStatement.setString(4, dateReleaseMovie);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
