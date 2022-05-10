package nl.inholland.myfirstapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Guitar {
    @Id
    @GeneratedValue
    private long id;
    private String model;

    @ManyToOne
    @JsonIgnoreProperties("guitars")
    private Brand brand;

    public Guitar() {
        // empty constructor needed
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
