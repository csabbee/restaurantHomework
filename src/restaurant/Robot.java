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
        System.out.println(order.toString()+" is added to the queue");
        orderQueue.add(order);
    }

    public void makeNextOrder() {
        if(orderQueue.size() > 0){
            Order order = orderQueue.poll(); 
            System.out.println("preparing order: "+order.toString());
            order.getCashier().orderFinished();
        }
    }
}
