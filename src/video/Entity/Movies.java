package video.Entity;
import video.Entity.People;
/**
 * Created by Vinty on 06.04.2017.
 */
public class Movies {
    private long id;
    private String nameMovie;
    private int genreMovie;
    private int countryMovie;
    private String dateReleaseMovie;
    private People people;

    public Movies(long id, String nameMovie, int genreMovie, int countryMovie,
                   String dateReleaseMovie, People people) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
        this.countryMovie = countryMovie;
        this.dateReleaseMovie = dateReleaseMovie;
        this.people = people;
    }
    public Movies(long id, String nameMovie, int genreMovie, int countryMovie,
                  String dateReleaseMovie) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
        this.countryMovie = countryMovie;
        this.dateReleaseMovie = dateReleaseMovie;
    }
    public Movies(String nameMovie, int genreMovie, int countryMovie, String dateReleaseMovie){
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
        this.countryMovie = countryMovie;
        this.dateReleaseMovie = dateReleaseMovie;
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

    public int getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(int genreMovie) {
        this.genreMovie = genreMovie;
    }

    public int getCountryMovie() {
        return countryMovie;
    }

    public void setCountryMovie(int countryMovie) {
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
