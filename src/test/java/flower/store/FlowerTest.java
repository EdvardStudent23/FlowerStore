package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;

    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testNegativePrice() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flower.setPrice(-34);
        });
        Assertions.assertEquals("Price mustn`t be negative", exception.getMessage(), "Should throw exception for negative price");
    }

    @Test
    public void testNegativeLength() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flower.setSepalLength(-35.6);
        });
        Assertions.assertEquals("Sepal length mustn`t be negative", exception.getMessage(), "Should throw exception for negative sepal length");
    }

    @Test
    public void SetSepalLength() {
        flower.setSepalLength(6.6);
        Assertions.assertEquals(6.6, flower.getSepalLength(), "Sepal length should be set correctly");
    }


    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }

    @Test
    public void testSetAndGetFlowerType() {
        flower.setFlowerType(FlowerType.ROSE);
        Assertions.assertEquals(FlowerType.ROSE, flower.getFlowerType(), "Flower type should be set correctly");
    }
}

