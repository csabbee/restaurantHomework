package client;

import restaurant.Cashier;
import restaurant.Restaurant;

public class Client implements Runnable{

    private double happiness;
    private Restaurant restaurant;
    
    public Client(Restaurant restaurant) {
        super();
        this.restaurant = restaurant;
    }
    
    @Override
    public void run() {
        Cashier cashier = restaurant.getCashier();
        while(cashier == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            cashier = restaurant.getCashier();
        }
        
        
    }
}
