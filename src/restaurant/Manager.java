package restaurant;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private static final Manager INSTANCE;
    private int costumerNumber;
    private AtomicInteger numberOfOrders = new AtomicInteger();
    
    static {
        INSTANCE = new Manager();
    }

    private Manager() {
        
    }

    public static Manager getInstance() {
        return INSTANCE;
    }

    public int getCostumerNumber() {
        return costumerNumber;
    }
    
    public void incrementCusotmerNumber(){
        costumerNumber++;
    }

    public AtomicInteger getNumberOfOrders() {
        return numberOfOrders;
    }
    
    public void incrementNumberOfOrders(){
        numberOfOrders.incrementAndGet();
    }
}
