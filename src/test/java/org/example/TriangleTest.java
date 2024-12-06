package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testGetArea() {
        Triangle triangle = new Triangle("Test Triangle", 3, 4, 5);
        double s = (3 + 4 + 5) / 2.0;
        double expectedArea = Math.sqrt(s * (s - 3) * (s - 4) * (s - 5));
        assertEquals(expectedArea, triangle.getArea(), 0.0001);
    }

    @Test
    public void testGetPerimeter() {
        Triangle triangle = new Triangle("Test Triangle", 3, 4, 5);
        double expectedPerimeter = 3 + 4 + 5;
        assertEquals(expectedPerimeter, triangle.getPerimeter(), 0.0001);
    }

    @Test
    public void testParameters() {
        Triangle triangle = new Triangle("Test Triangle", 3, 4, 5);

        triangle.setId(10);
        triangle.setName("New Triangle");
        triangle.setA(10);
        triangle.setB(10);
        triangle.setC(10);

        double a = triangle.getA();
        double b = triangle.getB();
        double c = triangle.getC();
    }
}