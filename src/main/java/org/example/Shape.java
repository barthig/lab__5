package org.example;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@JsonDeserialize(using = ShapeDeserializer.class)

public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public Color color;

    public Shape() {
        this.color = new Color(255, 255, 255, 1);
    }

    public Shape(String name) {
        this.name = name;
        this.color = new Color(255, 255, 255, 1);
    }

    public Shape(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
