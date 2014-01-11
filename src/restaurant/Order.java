package restaurant;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import food.product.Product;

public class Order {

    private List<Product> orderedProducts;
    private Client client;
    private Cashier cashier;

    public Order(Cashier cashier, Client client) {
        super();
        orderedProducts = new ArrayList<>();
        this.client = client;
        this.cashier = cashier;
    }

    public void addProduct(Product product) {
        orderedProducts.add(product);
    }

    public void setClient(Client client) {
        System.out.println(client.toString()+" is set to "+toString());
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public List<Product> getOrderedProducts() {
        return new ArrayList<>(orderedProducts);
    }
}
