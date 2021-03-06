package video.dao;
import video.Entity.People;
import video.connection.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Created by Vinty on 09.04.2017.
 */
public class PeopleDao {
    private static final Object LOCK = new Object();
    private static PeopleDao INSTANCE = null;

    public static PeopleDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PeopleDao();
                }
            }
        }
        return INSTANCE;
    }

    public Optional<People> addPeople(People people) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO people (name, family, s_name, date_bday, id_role) " +
                            " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, people.getNamePeople());
                preparedStatement.setString(2, people.getFamilyPeople());
                preparedStatement.setString(3, people.getsNamePeople());
                preparedStatement.setString(4, people.getDateOfBirthPeople());
                preparedStatement.setInt(5, people.getRole());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if(generatedKeys.next()){
                    people.setId(generatedKeys.getLong(1));
                    return Optional.of(people);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<People> getPeopleByMovieId(long idMovie) {
        List<People> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT     movies.id,\n" +
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
                        int role = resultSet.getInt("roles.name");
                        String namePeople = resultSet.getString("people.name");
                        String familyPeople = resultSet.getString("people.family");
                        String sNamePeople = resultSet.getString("people.s_name");
                        String dateOfBirthPeople = resultSet.getString("people.date_bday");
                        People people = new People(idPeople,
                                                   namePeople,
                                                   familyPeople,
                                                   sNamePeople,
                                                   dateOfBirthPeople,
                                                   role);
                        result.add(people);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
