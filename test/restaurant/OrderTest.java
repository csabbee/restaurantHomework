package restaurant;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import client.Client;
import food.product.Product;
import food.product.concrete.HotDog;

public class OrderTest {

    private Order underTest;
    
    @Before
    public void setUp(){
        IMocksControl control = EasyMock.createNiceControl();
        Cashier cashier = control.createMock(Cashier.class);
        Client client = control.createMock(Client.class);
        underTest = new Order(cashier, client);
    }
    
    @Test
    public void testAddProduct(){
        //GIVEN
        Product product = new HotDog(1);
        underTest.addProduct(product);
        //WHEN
        List<Product> expected = new ArrayList<>();
        expected.add(product);
        List<Product> actual = underTest.getOrderedProducts();
        //THEN
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testAddToTab(){
        //GIVEN
        underTest.addToTab(2d);
        //WHEN
        double expected = 2d;
        double actual = underTest.getTab();
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
    }
}
