package flower.store;

import lombok.Getter;
import lombok.Setter;



@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower() {
    }

    public Flower(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price mustn`t be negative");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSepalLength(double sepalLength) {
        if (sepalLength <= 0) {
            throw new IllegalArgumentException("Sepal length mustn`t be negative");
        }
        this.sepalLength = sepalLength;
    }
    
    public String getColor() {
        return color.toString();
    }
}
