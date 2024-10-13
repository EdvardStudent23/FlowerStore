package flower.store;
import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private List<FlowerPack> flowerPacks = new ArrayList<>();

    public void add(FlowerPack pack) {
        flowerPacks.add(pack);
    }

    public double getPrice() {
        double totalPrice = 0;
        for (FlowerPack pack : flowerPacks) {
            totalPrice += pack.getPrice();
        }
        return totalPrice;
    }

    public List<FlowerPack> getPacks() {
        return flowerPacks;
    }
}