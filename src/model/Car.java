package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Car {
    private Long id;
    private String name;
    private String model;
    private String brand;

    private String color;
    private LocalDate releaseDate;

    public Car(Long id, String name, String model, String brand, String color, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return "Name = " + name +
                ", Model = " + model +
                ", Brand = " + brand +
                ", id = " + id +
                ", Color = " + color +
                ", Release Date = " + dateTimeFormatter.format(releaseDate);
    }
}
