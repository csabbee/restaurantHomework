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
        underTest.getDiscount();
        //WHEN
        underTest.modifyOrder(product);
        EasyMock.expect(product.getPrice()).andReturn(100d);
        EasyMock.expectLastCall();
        EasyMock.expect(product.getPrice()).andReturn(100d);
        EasyMock.expectLastCall();
        EasyMock.replay(order, product, order);
        double expected = 90d;
        double actual = order.getTab();
        //THEN
        Assert.assertEquals(expected, actual, 0.0);
    }
}
