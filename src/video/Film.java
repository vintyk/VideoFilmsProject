package video;

import java.util.Date;

/**
 * Created by User on 28.03.2017.
 */
public class Film {
    private String nameFilm;
    private String actorsFilm;
    private String producerFilm;
    private String countryFilm;
    private String genreFilm;
    private Date dateReleaseFilm;

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getActorsFilm() {
        return actorsFilm;
    }

    public void setActorsFilm(String actorsFilm) {
        this.actorsFilm = actorsFilm;
    }

    public String getProducerFilm() {
        return producerFilm;
    }

    public void setProducerFilm(String producerFilm) {
        this.producerFilm = producerFilm;
    }

    public String getCountryFilm() {
        return countryFilm;
    }

    public void setCountryFilm(String countryFilm) {
        this.countryFilm = countryFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    public Date getDateReleaseFilm() {
        return dateReleaseFilm;
    }

    public void setDateReleaseFilm(Date dateReleaseFilm) {
        this.dateReleaseFilm = dateReleaseFilm;
    }
}