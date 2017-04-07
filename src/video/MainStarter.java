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

        //addUser("Валерий", "Нечай", "Сергеевич", "vn@ecp.by", 2, "qwerty" );
        //addUser("Бобейко", "Александр", "Григорьевич", "ab@ecp.by", 2, "qwerty2" );
        addMovie("От заката до рассвета", 4, 1, "1992-01-01");

//        List<Movies> movies = getMoviesByYear(1994);
//        movies.stream().forEach(System.out::println);
//
//        List<People> people = getPeopleByMovieId(6L);
//        people.stream().forEach(System.out::println);

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

        private static List<Movies> getMoviesByYear(int year) {
        List<Movies> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
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

    private static List<People> getPeopleByMovieId(long idMovie) {
        List<People> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT movies.id,\n" +
                            "       roles.name,\n" +
                            "       people.name,\n" +
                            "       people.family,\n" +
                            "       people.s_name,\n" +
                            "       people.date_bday\n" +
                            "FROM ((movies_project.movie_people_role    movie_people_role\n" +
                            "       INNER JOIN movies_project.roles roles\n" +
                            "          ON (movie_people_role.id_role = roles.id))\n" +
                            "      INNER JOIN movies_project.people people\n" +
                            "         ON     (people.id_role = roles.id)\n" +
                            "            AND (movie_people_role.id_people = people.Id))\n" +
                            "     INNER JOIN movies_project.movies movies\n" +
                            "        ON (movie_people_role.id_movie = movies.id)\n" +
                            "        where movies.id = ?\n" +
                            "ORDER BY roles.name DESC")) {
                preparedStatement.setLong(1, idMovie);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while(resultSet.next()) {
                        long idPeople = resultSet.getLong("movies.id");
                        String role = resultSet.getString("roles.name");
                        String namePeople = resultSet.getString("people.name");
                        String familyPeople = resultSet.getString("people.family");
                        String sNamePeople = resultSet.getString("people.s_name");
                        String dateOfBirthPeople = resultSet.getString("people.date_bday");
                        People people = new People(idPeople, namePeople, familyPeople, sNamePeople, dateOfBirthPeople, role);
                        result.add(people);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void addUser(String nameUser,
                                String familyUser,
                                String sNameUser,
                                String eMailUser,
                                int privilege_id,
                                String passwordUser) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (name, family, s_name, password, privilege_id, e_mail) " +
                            " VALUES (?, ?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, nameUser);
                preparedStatement.setString(2, familyUser);
                preparedStatement.setString(3, sNameUser);
                preparedStatement.setString(4, eMailUser);
                preparedStatement.setInt(5, privilege_id);
                preparedStatement.setString(6, passwordUser);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addMovie(String nameMovie,
                                 int genreMovie,
                                 int countryMovie,
                                 String dateReleaseMovie) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
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
