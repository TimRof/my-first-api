package nl.inholland.myfirstapi.model.dto.guitar;

import nl.inholland.myfirstapi.model.dto.DTOEntity;

public class GuitarCreateDTO implements DTOEntity
{
    private String brand;
    private String model;

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
}
