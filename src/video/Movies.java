package video;

import java.util.Date;

/**
 * Created by Vinty on 06.04.2017.
 */
public class Movies {
    private long id;
    private String nameMovie;
    private String genreMovie;
    private String countryMovie;
    private String dateReleaseMovie;
    private People people;

    public Movies(long id, String nameMovie, String genreMovie, String countryMovie, String dateReleaseMovie, People people) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
        this.countryMovie = countryMovie;
        this.dateReleaseMovie = dateReleaseMovie;
        this.people = people;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

    public String getCountryMovie() {
        return countryMovie;
    }

    public void setCountryMovie(String countryMovie) {
        this.countryMovie = countryMovie;
    }

    public String getDateReleaseMovie() {
        return dateReleaseMovie;
    }

    public void setDateReleaseMovie(String dateReleaseMovie) {
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", nameMovie='" + nameMovie + '\'' +
                ", genreMovie='" + genreMovie + '\'' +
                ", countryMovie='" + countryMovie + '\'' +
                ", dateReleaseMovie=" + dateReleaseMovie +
                ", people=" + people +
                '}';
    }
}
