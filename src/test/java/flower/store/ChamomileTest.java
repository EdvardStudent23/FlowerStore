package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ChamomileTest {

    @Test
    public void testFlowerType() {
        Chamomile chamomile = new Chamomile();
        Assertions.assertEquals(FlowerType.CHAMOMILE, chamomile.getFlowerType());
    }
}