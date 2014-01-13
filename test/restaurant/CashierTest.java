package restaurant;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import client.Client;
import food.extra.Extra;
import food.product.Product;

public class CashierTest {

    private Cashier underTest;
    private Product product;
    private Order order;
    private Extra extra;
    private Client client;
    
    @Before
    public void setUp(){
        IMocksControl control = EasyMock.createNiceControl();
        client = control.createMock(Client.class);
        extra = control.createMock(Extra.class);
        product = control.createMock(Product.class);
        order = control.createMock(Order.class);
        product.addExtra(extra);
        underTest = new Cashier(order);
    }
    
    @Test
    public void testModifyOrderWhenThereIsDiscount(){
        //GIVEN
        order = new Order(underTest, client);
        underTest = new Cashier(order);
        underTest.getDiscount();
        //WHEN
        EasyMock.expect(product.getPrice()).andReturn(100d);
        EasyMock.expectLastCall();
        EasyMock.replay(product);
        underTest.modifyOrder(product);
        double expected = 90d;
        double actual = order.getTab();
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
    }
    
    @Test
    public void testModifyOrderWhenThereIsNoDiscount(){
        //GIVEN
        order = new Order(underTest, client);
        underTest = new Cashier(order);
        //WHEN
        EasyMock.expect(product.getPrice()).andReturn(100d);
        EasyMock.expectLastCall();
        EasyMock.replay(product);
        underTest.modifyOrder(product);
        double expected = 100d;
        double actual = order.getTab();
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
    }
    
    @Test
    public void testStartOrdering(){
        //GIVEN as in setUp
        underTest.startOrdering(client);
    }
    
    @Test
    public void testFinishOrder(){
        //GIVEN as in setUp
        underTest.finishOrder();
    }
    
    @Test
    public void testOrderFinished(){
        //GIVEN
        //WHEN
        EasyMock.expect(order.getClient()).andReturn(client);
        EasyMock.expectLastCall();
        EasyMock.replay(order);
        System.out.println(order.getClient());
        underTest.orderFinished();
        //THEN
        EasyMock.verify(order);
    }
}
