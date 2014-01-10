package restaurant;

import java.util.ArrayList;
import java.util.List;

import food.extra.Extra;
import food.product.Product;

public class Restaurant {

    private List<Cashier> cashiers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Extra> extras = new ArrayList<>();
    
    public Cashier getCashier(){
        Cashier cashier = null;
        if(!cashiers.isEmpty()){
            synchronized (cashiers){
                if(!cashiers.isEmpty()){
                    cashier = cashiers.remove(cashiers.size()-1);
                }
            }
        }
        return cashier;
    }
    
    public void addCashier(Cashier cashier){
        cashiers.add(cashier);
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    public List<Extra> getExtras() {
        return new ArrayList<Extra>(extras);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public Extra getExtra(int index) {
        return extras.get(index);
    }
    
    public void addNewProduct(Product product){
        products.add(product);
    }
    
    public void addNewExtra(Extra extra){
        extras.add(extra);
    }
}
