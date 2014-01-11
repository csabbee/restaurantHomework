package restaurant;

public class Manager {
    private static final Manager INSTANCE;
    private int costumerNumber;
    
    static {
        INSTANCE = new Manager();
    }

    private Manager() {
        
    }

    public static Manager getInstance() {
        return INSTANCE;
    }

    public static void sfoo() {
        
    }

    public int getCostumerNumber() {
        return costumerNumber;
    }
    
    public void incrementCusotmerNumber(){
        costumerNumber++;
    }
}
