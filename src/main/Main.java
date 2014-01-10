package main;
import restaurant.Restaurant;
import client.Client;


public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        int clients = 0;
        
        while(clients != 10){
            Thread t = new Thread(new Client(restaurant));
            t.start();
            try {
                Thread.sleep(MyRandom.nextRandom(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
