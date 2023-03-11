package week3;

import java.time.LocalDate;

public class Programmer extends Person{
    private int yearsOfExperience;
    private String preferedLanguage;

    public Programmer(String name, LocalDate birthDate, int yearsOfExperience, String preferedLanguage) {
        super(name, birthDate);
        this.yearsOfExperience = yearsOfExperience;
        this.preferedLanguage = preferedLanguage;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPreferedLanguage() {
        return preferedLanguage;
    }

    public void setPreferedLanguage(String preferedLanguage) {
        this.preferedLanguage = preferedLanguage;
    }
}
