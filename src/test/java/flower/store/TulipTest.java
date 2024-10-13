package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TulipTest {

    @Test
    public void testFlowerType() {
        Tulip tulip = new Tulip();
        Assertions.assertEquals(FlowerType.TULIP, tulip.getFlowerType());
    }
}