package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StoreTest {
    private Store store;
    private FlowerBucket bucket1;
    private FlowerBucket bucket2;
    private FlowerBucket bucket3;
    private FlowerPack tulipPack;
    private FlowerPack chamomilePack;
    private FlowerPack rosePack1;
    private FlowerPack rosePack2;

    @BeforeEach
    public void init() {
        store = new Store();
        bucket1 = new FlowerBucket();
        bucket2 = new FlowerBucket();
        bucket3 = new FlowerBucket();

        rosePack2 = new FlowerPack(new Rose(), 10);
        rosePack1 = new FlowerPack(new Rose(), 5);
        tulipPack = new FlowerPack(new Tulip(), 11);
        chamomilePack = new FlowerPack(new Chamomile(), 4);

        bucket1.add(rosePack1);
        bucket2.add(tulipPack);
        bucket3.add(rosePack2);
        bucket2.add(rosePack2);
        bucket3.add(chamomilePack);

        store.addBucket(bucket1);
        store.addBucket(bucket2);
        store.addBucket(bucket3);
    }

    @Test
    public void testSearchTypeRose() {
        List<FlowerBucket> result = store.search(FlowerType.ROSE);
        Assertions.assertFalse(result.isEmpty(), "There is at least one bucket with rose");
        Assertions.assertEquals(3, result.size(), "There should be 3 buckets with rose");
    }

    @Test
    public void testSearchTypeTulip() {
        List<FlowerBucket> result = store.search(FlowerType.TULIP);
        Assertions.assertFalse(result.isEmpty(), "There is at least 1 bucket of Tulip");
        FlowerPack pack = result.get(0).getPacks().get(0);
        Assertions.assertEquals(11, pack.getQuantity(), "There should be a pack of 11 Tulips");
    }
    @Test
    public void testSearchByFlowerType_Chamomile_InMixedBucket() {
        List<FlowerBucket> result = store.search(FlowerType.CHAMOMILE);
        Assertions.assertFalse(result.isEmpty(), "There is at least 1 bucket with CHAMOMILE");
        Assertions.assertEquals(1, result.size(), "There should be only 1 bucket with CHAMOMILE");
    }
    
    @Test
    public void testEmptyStore() {
        Store emptyStore = new Store();
        List<FlowerBucket> result = emptyStore.search(FlowerType.CHAMOMILE);
        Assertions.assertTrue(result.isEmpty(), "There is not any buckets containing chamomile");
        List<FlowerBucket> result2 = emptyStore.search(FlowerType.ROSE);
        Assertions.assertTrue(result2.isEmpty(), "There is not any buckets containing rose");
        List<FlowerBucket> result3 = emptyStore.search(FlowerType.TULIP);
        Assertions.assertTrue(result3.isEmpty(), "There is not any buckets containing tulip");
        boolean isStoreEmpty = result.size() == 0 && result2.size() == 0 && result3.size() == 0;
        Assertions.assertTrue(isStoreEmpty, "The store should be empty as no buckets contain any flowers.");
    }
}