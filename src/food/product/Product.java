package food.product;

import java.util.ArrayList;
import java.util.List;

import food.extra.Extra;

public abstract class Product {

    private double effect;
    private double price;
    private boolean discount;
    private List<Extra> extras = new ArrayList<>();
    
    protected Product(double price){
        this.price = price;
    }
    
    public double getEffect() {
        for (Extra extra : extras) {
            effect += extra.effect(this, effect);
        }
        return effect;
    }
    public void setEffect(double effect) {
        this.effect = effect;
    }
    
    public void addExtra(Extra extra){
        extras.add(extra);
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount() {
        discount = true;
    }

    public double getPrice() {
        return price;
    }
    
}
