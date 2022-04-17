package nl.inholland.myfirstapi.model.dto.guitar;

import nl.inholland.myfirstapi.model.dto.DTOEntity;

public class GuitarGetDTO implements DTOEntity
{

    private long id;
    private String brand;
    private String model;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

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
