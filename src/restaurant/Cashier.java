package restaurant;

import client.Client;
import food.product.Product;

public class Cashier {

    private static final double DISCOUNT = 0.9;
    private Order order;
    private boolean discount;

    public Cashier(Order order) {
        this.order = order;
    }

    public Cashier() {
    }

    public void modifyOrder(Product product){
        if(discount){
            order.addToTab(product.getPrice()*DISCOUNT);
            discount = false;
        } else {
            order.addToTab(product.getPrice());
        }
        Manager.getInstance().incrementNumberOfOrders();
        order.addProduct(product);
    }

    public void startOrdering(Client client) {
        System.out.format("%s is here%n", client.toString());
        order = new Order(this, client);
    }

    public void finishOrder() {
        System.out.println(toString()+" is adding order to the queue");
        System.out.println("Adding order: "+order.toString()+" to the queue");
        System.out.println("The tab for the order: "+order.getTab());
        Robot.getInstance().addOrder(order);
    }

    public void orderFinished() {
        System.out.format("%s ", order.toString());
        System.out.format("%s%n", order.getClient().toString());
        order.getClient().orderFinished(order);
    }

    public void getDiscount() {
        discount = true;
    }
    
    
}
