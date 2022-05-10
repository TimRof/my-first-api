package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "brand")
    @JsonIgnoreProperties("brand")
    private Set<Guitar> guitars = new HashSet<>();

    public Brand(String name) {
        this.name = name;
    }

    public Brand(long id) {
        this.id = id;
    }

    public Brand() {
        // empty constructor needed
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<Guitar> guitars) {
        this.guitars = guitars;
    }
}
