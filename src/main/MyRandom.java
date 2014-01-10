package main;

import java.util.Random;

public class MyRandom {

    private static Random random;
    private static final MyRandom INSTANCE;

    static {
        INSTANCE = new MyRandom();
        random = new Random();
    }

    private MyRandom() {
        
    }

    public static MyRandom getInstance() {
        return INSTANCE;
    }

    public static int nextRandom(int n) {
        return random.nextInt(n);
    }
}
