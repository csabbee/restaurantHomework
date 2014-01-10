package food.extra.concrete;

import food.extra.Extra;
import food.product.Product;

public class Mustard extends Extra {

    @Override
    public double effect(Product product, double effect) {
        product.setEffect(0);
        return 1;
    }

}
