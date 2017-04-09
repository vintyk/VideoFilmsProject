package video.Entity;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by Vinty on 02.04.2017.
 */
public class People {
    private long id;
    private String namePeople;
    private String familyPeople;
    private String sNamePeople;
    private String dateOfBirthPeople;
    private int role;
    private Set<Movies> moviesSet = new HashSet<>();

    public People(long id, String namePeople, String familyPeople, String sNamePeople,
                  String dateOfBirthPeople, int role) {
        this.id = id;
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.sNamePeople = sNamePeople;
        this.dateOfBirthPeople = dateOfBirthPeople;
        this.role = role;
    }
    public People(String namePeople, String familyPeople, String sNamePeople,
                  String dateOfBirthPeople, int role) {
        this.id = id;
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.sNamePeople = sNamePeople;
        this.dateOfBirthPeople = dateOfBirthPeople;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public String getFamilyPeople() {
        return familyPeople;
    }

    public void setFamilyPeople(String familyPeople) {
        this.familyPeople = familyPeople;
    }

    public String getsNamePeople() {
        return sNamePeople;
    }

    public void setsNamePeople(String sNamePeople) {
        this.sNamePeople = sNamePeople;
    }

    public String getDateOfBirthPeople() {
        return dateOfBirthPeople;
    }

    public void setDateOfBirthPeople(String dateOfBirthPeople) {
        this.dateOfBirthPeople = dateOfBirthPeople;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Set<Movies> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movies> moviesSet) {
        this.moviesSet = moviesSet;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", namePeople='" + namePeople + '\'' +
                ", familyPeople='" + familyPeople + '\'' +
                ", sNamePeople='" + sNamePeople + '\'' +
                ", dateOfBirthPeople=" + dateOfBirthPeople +
                ", role='" + role + '\'' +
                ", moviesSet=" + moviesSet +
                '}';
    }
}
