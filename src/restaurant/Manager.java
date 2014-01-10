package restaurant;

public class Manager {
    private static final Manager INSTANCE;

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
}
