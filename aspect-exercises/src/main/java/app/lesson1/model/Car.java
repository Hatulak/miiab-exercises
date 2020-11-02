package app.lesson1.model;

import jdk.nashorn.internal.ir.annotations.Immutable;

//@Immutable
public class Car {

    private Long id;
    private String color;
    private String fuelType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
