package client;

import restaurant.Restaurant;

public class Client implements Runnable{

    private double happiness;
    private Restaurant restaurant;
    
    private Client(Restaurant restaurant) {
        super();
        this.restaurant = restaurant;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
}
