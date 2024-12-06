package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    public void testGetArea() {
        Rectangle rectangle = new Rectangle("Test Rectangle", 4, 6);
        double expectedArea = 4 * 6;
        assertEquals(expectedArea, rectangle.getArea(), 0.0001);
    }

    @Test
    public void testGetPerimeter() {
        Rectangle rectangle = new Rectangle("Test Rectangle", 4, 6);
        double expectedPerimeter = 2 * (4 + 6);
        assertEquals(expectedPerimeter, rectangle.getPerimeter(), 0.0001);
    }

    @Test
    public void testParameters() {
        Rectangle rectangle = new Rectangle("Test Rectangle", 4, 6);

        rectangle.setId(10);
        rectangle.setName("New Rectangle");
        rectangle.setWidth(10);
        rectangle.setHeight(10);

        double a = rectangle.getWidth();
        double b = rectangle.getHeight();
    }
}