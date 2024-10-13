package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FlowerPackTest {
    private FlowerPack flowerPack;
    private Flower rose;

    @BeforeEach
    public void init() {
        rose = new Flower(FlowerType.ROSE);
    }

    @Test
    public void testGetFlowerType_Rose() {
        flowerPack = new FlowerPack(rose, 6);
        Assertions.assertEquals(FlowerType.ROSE, flowerPack.getFlowerType(), "The type of a floower should be ROSE");
    }
}