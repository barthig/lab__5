package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CircleTest {
    @Test
    public void testGetArea() {
        Circle circle = new Circle("test Circle",7);
        double expectedArea = Math.PI*7*7;
        assertEquals(expectedArea, circle.getArea(), 0.0001);
    }

    @Test
    public void testGetPerimeter() {
        Circle circle = new Circle("test Circle",7);
        double expectedPerimeter = 2*Math.PI*7;
        assertEquals(expectedPerimeter, circle.getPerimeter(), 0.0001);
    }
    @Test
    public void testParametrs(){
        Circle circle = new Circle("test Circle",7);
        circle.setRadius(7);
        circle.setName("Test Circle");
        circle.setId(10);
        double r = circle.getRadius();

    }
}
