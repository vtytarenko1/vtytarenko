package HomeWork9;

import java.time.LocalDate;
import java.util.List;

public class Fruit {
    private FruitType fruitType;
    private int dayToLive;
    private LocalDate deliveryDate;
    private int price;
    private List<Vitamin> vitamins;

    public Fruit(FruitType fruitType, int dayToLive, LocalDate deliveryDate, int price, List<Vitamin> vitamins) {
        this.fruitType = fruitType;
        this.dayToLive = dayToLive;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.vitamins = vitamins;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public int getDayToLive() {
        return dayToLive;
    }

    public void setDayToLive(int dayToLive) {
        this.dayToLive = dayToLive;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Vitamin> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<Vitamin> vitamins) {
        this.vitamins = vitamins;
    }

    @Override
    public String toString() {
        return "Fruit [fruitType=" + fruitType + ", dayToLive=" + dayToLive + ", deliveryDate=" + deliveryDate
                + ", price=" + price + ", vitamins=" + vitamins + "]";
    }
}
