package restaurant;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import food.extra.Extra;
import food.extra.concrete.Mustard;
import food.product.Product;
import food.product.concrete.Chips;

public class RestaurantTest {

    private Extra extra;
    private Product product;
    
    @Before
    public void setUp(){
        extra = new Mustard();
        product = new Chips(1d);
    }
    
    @Test
    public void testAddNewProduct(){
        //GIVEN
        Restaurant.getInstance().addNewProduct(product);
        //WHEN
        Product expected = product;
        Product actual = Restaurant.getInstance().getProduct(0);
        List<Product> expected2 = new ArrayList<>();
        List<Product> actual2 = Restaurant.getInstance().getProducts();
        expected2.add(product);
        //THEN
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }
    
    @Test
    public void testAddNewExtra(){
        //GIVEN
        Restaurant.getInstance().addNewExtra(extra);
        //WHEN
        Extra expected = extra;
        Extra actual = Restaurant.getInstance().getExtra(0);
        List<Extra> expected2 = new ArrayList<>();
        expected2.add(extra);
        List<Extra> actual2 = Restaurant.getInstance().getExtras();
        //THEN
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }
}
