package food.product;

import java.util.ArrayList;
import java.util.List;

import food.extra.Extra;

public abstract class Product {

    private double effect;
    private List<Extra> extras = new ArrayList<>();
    
    public double getEffect() {
        return effect;
    }
    public void setEffect(double effect) {
        this.effect = effect;
    }
    
    public void addExtra(Extra extra){
        extras.add(extra);
    }
}
