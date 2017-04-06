package video;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

/**
 * Created by Vinty on 06.04.2017.
 */
public class MainStarter {
    private static final String URL = "jdbc:mysql://localhost:3306/movies_project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         //  printMovieById(1);
        //List<Movies> movies = getMovieById(1L);
        //movies.stream().forEach(System.out::println);
        System.out.println(getMovieById(1L));
    }
    private static Movies getMovieById(long movieId) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
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

        private static void printMovieById (long id) {
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT movies.name,\n" +
                                "       people.name,\n" +
                                "       people.family,\n" +
                                "       roles.name\n" +
                                "FROM ((movies_project.movie_people_role    movie_people_role\n" +
                                "       INNER JOIN movies_project.roles roles\n" +
                                "          ON (movie_people_role.id_role = roles.id))\n" +
                                "      INNER JOIN movies_project.people people\n" +
                                "         ON     (people.id_role = roles.id)\n" +
                                "            AND (movie_people_role.id_people = people.Id))\n" +
                                "     INNER JOIN movies_project.movies movies\n" +
                                "        ON (movie_people_role.id_movie = movies.id)\n" +
                                "        where movies.id = ?\n" +
                                "ORDER BY movies.name ASC, roles.name DESC")) {
                    preparedStatement.setLong(1, id);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            //if (resultSet.next()) {
                            System.out.println("Название: " + resultSet.getString("movies.name"));
                            System.out.println("Имя: " + resultSet.getString("people.name"));
                            System.out.println("Фамилия: " + resultSet.getString("people.family"));
                            System.out.println("Роль: " + resultSet.getString("roles.name"));
                            // }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}