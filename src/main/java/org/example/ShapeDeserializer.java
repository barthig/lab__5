package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

public class ShapeDeserializer extends JsonDeserializer<Shape> {

    @Override
    public Shape deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode node = mapper.readTree(parser);

        // Domyślny kolor, jeśli nie został podany w JSON
        Color color = new Color(255, 255, 255, 0);
        if (node.has("color")) {
            JsonNode colorNode = node.get("color");
            color = new Color(
                    colorNode.get("red").asInt(),
                    colorNode.get("green").asInt(),
                    colorNode.get("blue").asInt(),
                    (float) colorNode.get("alpha").asDouble()
            );
        }

        // Sprawdzenie pola "type" w JSON
        if (!node.has("type")) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Pole 'type' jest wymagane. Dozwolone wartości: 'rectangle', 'triangle', 'circle'."
            );
        }

        String type = node.get("type").asText();

        // Tworzenie odpowiedniej figury na podstawie "type"
        switch (type.toLowerCase()) {
            case "circle":
                if (!node.has("radius")) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Circle wymaga pola 'radius'."
                    );
                }
                Circle circle = new Circle();
                circle.setRadius(node.get("radius").asDouble());
                circle.setName(node.has("name") ? node.get("name").asText() : "Unnamed Circle");
                circle.color = color;
                return circle;

            case "triangle":
                if (!node.has("a") || !node.has("b") || !node.has("c")) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Triangle wymaga pól 'a', 'b' i 'c'."
                    );
                }
                Triangle triangle = new Triangle();
                triangle.setA(node.get("a").asDouble());
                triangle.setB(node.get("b").asDouble());
                triangle.setC(node.get("c").asDouble());
                triangle.setName(node.has("name") ? node.get("name").asText() : "Unnamed Triangle");
                triangle.color = color;
                return triangle;

            case "rectangle":
                if (!node.has("height") || !node.has("width")) {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Rectangle wymaga pól 'height' i 'width'."
                    );
                }
                Rectangle rectangle = new Rectangle();
                rectangle.setHeight(node.get("height").asDouble());
                rectangle.setWidth(node.get("width").asDouble());
                rectangle.setName(node.has("name") ? node.get("name").asText() : "Unnamed Rectangle");
                rectangle.color = color;
                return rectangle;

            default:
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Nieznany typ Shape: 'type' musi być jednym z 'rectangle', 'triangle', 'circle'."
                );
        }
    }
}
