package org.example;


public class Main {
    public static void main(String[] args) {
        ShapeDAO shapeDAO = new ShapeDAO();

        Shape triangle = new Triangle("triangle",3,4,5,new Color(255,255,255,1));
        Shape rectangle= new Rectangle("rectangle",5,6,new Color(255,255,255,1));
        Shape circle=new Circle("circle",3,new Color(255,255,255,1));

        shapeDAO.saveShape(triangle);
        shapeDAO.saveShape(rectangle);
        shapeDAO.saveShape(circle);

        System.out.println("pobrane figury");
        Shape retrievedTriangle = shapeDAO.getShape(Triangle.class, triangle.getId());
        Shape retrievedRectangle = shapeDAO.getShape(Rectangle.class, rectangle.getId());
        Shape retrievedCircle = shapeDAO.getShape(Circle.class, circle.getId());

        System.out.println(retrievedTriangle);
        System.out.println(retrievedRectangle);
        System.out.println(retrievedCircle);

        retrievedTriangle.setName("UpdatedTriangle");
        ((Triangle)retrievedTriangle).setB(10);
        shapeDAO.updateShape(retrievedTriangle);

        retrievedRectangle.setName("UpdatedRectangle");
        ((Rectangle)retrievedRectangle).setWidth(5);
        shapeDAO.updateShape(retrievedRectangle);

        retrievedCircle.setName("UpdatedCircle");
        ((Circle)retrievedCircle).setRadius(5);
        shapeDAO.updateShape(retrievedCircle);

        System.out.println("\n po uaktualnieniu");
        retrievedTriangle=shapeDAO.getShape(Triangle.class, triangle.getId());
        retrievedRectangle=shapeDAO.getShape(Rectangle.class, rectangle.getId());
        retrievedCircle=shapeDAO.getShape(Circle.class, circle.getId());


        System.out.println(retrievedTriangle.getName()+"area"+((Triangle)retrievedTriangle).getArea()+", perimeter: "+((Triangle)retrievedTriangle).getPerimeter());
        System.out.println(retrievedRectangle.getName()+" area"+ ((Rectangle)retrievedRectangle).getArea()+", perimeter:"+((Rectangle)retrievedRectangle).getPerimeter() );
        System.out.println(retrievedCircle.getName()+" area "+((Circle)retrievedCircle).getArea()+", perimeter:"+((Circle)retrievedCircle).getPerimeter());

        System.out.println("\n po usuwanie figur");
        shapeDAO.deleteShape(triangle);
        shapeDAO.deleteShape(rectangle);
        shapeDAO.deleteShape(circle);

        System.out.println("\n potwierdzenie po usuwaniu figur");
        Shape deletedTriangle = shapeDAO.getShape(Triangle.class, triangle.getId());
        Shape deletedRectangle = shapeDAO.getShape(Rectangle.class, rectangle.getId());
        Shape deletedCircle = shapeDAO.getShape(Circle.class, circle.getId());

        System.out.println(deletedTriangle==null ? "traingle deleted":"traingle nadal isteniej ");
        System.out.println(deletedRectangle==null ? "rectangle deleted":"rectangle nadal isteniej ");
        System.out.println(deletedCircle==null ? "circle deleted":"circle nadal isteniej ");

        ShapeDAO.shutdown();

    }
}
