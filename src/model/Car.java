package model;

public class Car {
    private String name;
    private String model;
    private String brand;
    private String id;
    private String color;
    private Integer releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Name = " + name +
                ", Model = " + model +
                ", Brand = " + brand +
                ", id = " + id +
                ", Color = " + color +
                ", Release Date = " + releaseDate + " year";
    }
}
