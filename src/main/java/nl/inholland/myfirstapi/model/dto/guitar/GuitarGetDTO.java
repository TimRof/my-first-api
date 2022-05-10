package nl.inholland.myfirstapi.model.dto.guitar;

import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.dto.DTOEntity;

public class GuitarGetDTO implements DTOEntity {

    private long id;
    private Brand brand;
    private String model;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
