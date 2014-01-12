package food.extra.concrete;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import food.product.Product;
import food.product.concrete.HotDog;

public class MustardTest {

    private Mustard underTest;
    private Product product;
    
    @Before
    public void setUp(){
        underTest = new Mustard();
        product = new HotDog(350d);
    }
    
    @Test
    public void testEffectReturnsOne(){
        //GIVEN as in setUp
        //WHEN
        double expected = 1;
        double actual = underTest.effect(product, 1);
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
        
    }
    
    @Test
    public void testEffectSetProductEffectToZero(){
        //GIVEN
        product.setEffect(10);
        underTest.effect(product, 1);
        //WHEN
        double expected = 0;
        double actual = product.getEffect();
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
    }
}
