package restaurant;

import client.Client;
import food.product.Product;

public class Cashier {

    private Order order;
    public Cashier(){
        order = new Order(this);
    }
    
    public void deleteOrder() {
        order = new Order(this);
    }

    public void modifyOrder(Product product){
        order.addProduct(product);
    }

    public void startOrdering(Client client) {
        System.out.format("%s is here%n", client.toString());
        order.setClient(client);
    }

    public void finishOrder() {
        System.out.println(toString()+" is adding order to the queue");
        System.out.println("Adding order: "+order.toString()+" to the queue");
        Robot.getInstance().addOrder(order);
        //deleteOrder();
    }

    public void orderFinished() {
        System.out.format("%s ", order.toString());
        System.out.format("%s%n", order.getClient().toString());
        order.getClient().orderFinished(order);
    }
    
    
}
