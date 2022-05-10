package nl.inholland.myfirstapi.model.dto.guitar;

import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.dto.DTOEntity;

public class GuitarUpdateDTO implements DTOEntity {
    private Brand brand;
    private String model;

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
