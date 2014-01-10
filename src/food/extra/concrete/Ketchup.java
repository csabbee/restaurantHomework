package food.extra.concrete;

import food.extra.Extra;
import food.product.Product;

public class Ketchup extends Extra {

    @Override
    public double effect(Product product) {
        product.setEffect(product.getEffect()*2);
        return 0;
    }

}
