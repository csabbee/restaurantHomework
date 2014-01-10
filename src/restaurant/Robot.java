package restaurant;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Robot{
    private static final Robot INSTANCE;
    private static Queue<Order> orderQueue; 
    
    static {
        INSTANCE = new Robot();
        orderQueue = new ConcurrentLinkedQueue<>();
    }

    private Robot() {}

    public static Robot getInstance() {
        return INSTANCE;
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public void makeNextOrder() {
        if(orderQueue.size() > 0){
            orderQueue.poll().getCashier().orderFinished();
        }
    }
}
