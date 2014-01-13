package restaurant;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

public class ManagerTest {

    @Test
    public void testincrementCusotmerNumber(){
        //WHEN
        Manager.getInstance().incrementCusotmerNumber();
        int expected = 1;
        int actual = Manager.getInstance().getCostumerNumber();
        //THEN
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testincrementNumberOfOrders(){
        //WHEN
        Manager.getInstance().incrementNumberOfOrders();
        int expected = new AtomicInteger(1).get();
        int actual = Manager.getInstance().getNumberOfOrders().get();
        //THEN
        Assert.assertEquals(expected, actual);
    }
}
