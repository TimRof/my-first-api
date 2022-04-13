package nl.inholland.myfirstapi.model;

public class Guitar {

    private long id;
    private String brand;
    private String model;

    public Guitar(long id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


}