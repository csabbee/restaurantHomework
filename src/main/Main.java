package main;
import restaurant.Cashier;
import restaurant.Restaurant;
import restaurant.Robot;
import client.Client;
import food.extra.concrete.Ketchup;
import food.extra.concrete.Mustard;
import food.product.concrete.Chips;
import food.product.concrete.HotDog;


public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        int clients = 0;
        init(restaurant);
        while(clients != 10){
            Thread t = new Thread(new Client(restaurant));
            t.start();
            try {
                Thread.sleep(MyRandom.nextRandom(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clients++;
            Robot.getInstance().makeNextOrder();
        }
    }

    
    private static void init(Restaurant restaurant) {
        restaurant.addCashier(new Cashier());
        restaurant.addCashier(new Cashier());
        restaurant.addCashier(new Cashier());
        restaurant.addNewExtra(new Ketchup());
        restaurant.addNewExtra(new Mustard());
        restaurant.addNewProduct(new Chips());
        restaurant.addNewProduct(new HotDog());
    }

}
