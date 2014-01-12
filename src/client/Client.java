package client;

import main.MyRandom;
import restaurant.Cashier;
import restaurant.Order;
import restaurant.Restaurant;
import food.extra.Extra;
import food.product.Product;

public class Client implements Runnable{

    private double happiness;
    private Restaurant restaurant;
    
    public Client(Restaurant restaurant) {
        super();
        happiness = 0.0;
        this.restaurant = restaurant;
        System.out.println("I am created");
    }
    
    @Override
    public void run() {
        Cashier cashier = restaurant.getCashier();
        while(cashier == null){
            try {
                System.out.println("I'm going to wait");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cashier = restaurant.getCashier();
        }
        System.out.println("My cashier is: "+cashier.toString());
        cashier.startOrdering(this);
        ordering(cashier);
    }

    private void ordering(Cashier cashier) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        while(true){
            int rand = MyRandom.nextRandom(100);
            //System.out.format(this.toString()+"'s next move: %s%n", rand);
            if(rand < 75){
                int numberOfProducts = restaurant.getProducts().size();
                int numberOfExtras = restaurant.getExtras().size();
                Product nextProduct = restaurant.getProduct(MyRandom.nextRandom(numberOfProducts));
                Extra extra = restaurant.getExtra(MyRandom.nextRandom(numberOfExtras));
                nextProduct.addExtra(extra);
                cashier.modifyOrder(nextProduct);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else 
            if(rand < 90) {
                cashier.finishOrder();
                restaurant.addCashier(cashier);
                break;
            } else 
            if( rand < 95){
                System.out.println("Yay I'm getting a discount!");
                cashier.getDiscount();
            } else
            if(rand < 100){
                restaurant.addCashier(cashier);
                System.out.println("ANGRY");
            }
        }
    }

    public void orderFinished(Order order) {
        consume(order);
    }

    private void consume(Order order) {
        System.out.format("%s is eating the order%n",this);
        for (Product product : order.getOrderedProducts()) {
            happiness += product.getEffect();
        }
        System.out.format("%s' happiness:%s%n",this,happiness);
    }
}
