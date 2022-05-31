package entity;

import java.util.Objects;

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
        return name+"(" + nationality +")";
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
