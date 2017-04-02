package video;

import java.time.LocalDate;

/**
 * Created by Vinty on 02.04.2017.
 */
public class People {
    private String namePeople;
    private String familyPeople;
    private String sNamePeople;
    private LocalDate dateOfBirthActor;

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

    public LocalDate getDateOfBirthActor() {
        return dateOfBirthActor;
    }

    public void setDateOfBirthActor(LocalDate dateOfBirthActor) {
        this.dateOfBirthActor = dateOfBirthActor;
    }
}
