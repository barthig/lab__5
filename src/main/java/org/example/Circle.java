package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "circle")
public class Circle extends Shape {
    @Column(name = "radius", nullable = false)
    private double radius;

    public Circle() {
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(String name, double radius, Color color) {
        super(name, color);
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
