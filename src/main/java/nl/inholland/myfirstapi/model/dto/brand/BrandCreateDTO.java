package nl.inholland.myfirstapi.model.dto.brand;

import nl.inholland.myfirstapi.model.dto.DTOEntity;

public class BrandCreateDTO implements DTOEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandCreateDTO(String name) {
        this.name = name;
    }

    public BrandCreateDTO() {
    }
}
