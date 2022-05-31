package entity;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDesc;
    private Date birthDate;
    private Country birthPlace;
    private Country countryName;
    private List<UserSkill> skill;
    public User(){
        
    }
    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String email,String phone,String profileDesc,  Date birthDate, Country birthPlace, Country countryName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDesc=profileDesc;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public List<UserSkill> getSkill() {
        return skill;
    }

    public void setSkill(List<UserSkill> skill) {
        this.skill = skill;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Country getCountryName() {
        return countryName;
    }

    public void setCountryName(Country countryName) {
        this.countryName = countryName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", profileDesc=" + profileDesc + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + ", countryName=" + countryName + ", skill=" + skill + '}';
    }

 
}
