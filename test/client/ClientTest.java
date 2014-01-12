package client;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import restaurant.Cashier;
import restaurant.Order;
import restaurant.Restaurant;
import food.extra.concrete.Mustard;
import food.product.Product;
import food.product.concrete.HotDog;

public class ClientTest {

    private Client underTest;
    private Restaurant restaurant;
    private Cashier cashier;
    private Order order;
    
    @Before
    public void setUp(){
        //IMocksControl control = EasyMock.createControl();
        IMocksControl control = EasyMock.createNiceControl();
        cashier = control.createMock(Cashier.class);
        //cashier = EasyMock.createNiceMock(Cashier.class);
        restaurant = control.createMock(Restaurant.class);
        restaurant.addCashier(cashier);
        order = control.createMock(Order.class);
        underTest = new Client(restaurant);
    }
    
    @Test(expected = NullPointerException.class)
    public void testRun(){
        //GIVEN
        EasyMock.expect(restaurant.getCashier()).andReturn(cashier);
        EasyMock.expectLastCall();
        EasyMock.replay(restaurant);
        //WHEN
        underTest.run();
        //THEN
        EasyMock.verify(restaurant);
    }
    
    @Test
    public void testOrderFinished(){
        //Given
        Product product = new HotDog(350d);
        product.addExtra(new Mustard());
        List<Product> products = new ArrayList<>();
        products.add(product);
        EasyMock.expect(order.getOrderedProducts()).andReturn(products);
        EasyMock.replay(order);
        //WHEN
        restaurant.addCashier(cashier);
        underTest.orderFinished(order);
        //THEN
        EasyMock.verify(order);
    }
}

