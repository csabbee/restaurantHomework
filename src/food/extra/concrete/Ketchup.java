package food.extra.concrete;

import food.extra.Extra;
import food.product.Product;

public class Ketchup extends Extra {

    @Override
    public double effect(Product product, double effect) {
        product.setEffect(effect*2);
        return 0;
    }

}
