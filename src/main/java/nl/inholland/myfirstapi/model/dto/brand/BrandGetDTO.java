package nl.inholland.myfirstapi.model.dto.brand;

import nl.inholland.myfirstapi.model.dto.DTOEntity;

public class BrandGetDTO implements DTOEntity {

    private long id;
    private String name;

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
}
