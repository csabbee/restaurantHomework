package food.extra.concrete;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import food.product.Product;
import food.product.concrete.HotDog;

public class KetchupTest {

    private Ketchup underTest;
    private Product product;
    
    @Before
    public void setUp(){
        underTest = new Ketchup();
        product = new HotDog(350);
    }
    
    @Test
    public void testEffectReturnsZero(){
        //GIVEN as in setUp
        //WHEN
        double expected = 0;
        double actual = underTest.effect(product, 1);
        //THEN
        Assert.assertEquals(expected, actual, 0.0);

    }
    
    @Test
    public void testEffectSetsProductEffect(){
        //GIVEN
        underTest.effect(product, 1);
        //WHEN
        double expected = 2;
        double actual = product.getEffect();
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
    }
}
