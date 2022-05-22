package entity;

public class Country {
    private Integer id;
    private String nationality;
    private String name;

    public Country() {
    }

    public Country(Integer id, String nationality, String name) {
        this.id = id;
        this.nationality = nationality;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id=" + id +
                ", nationality='" + nationality + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
