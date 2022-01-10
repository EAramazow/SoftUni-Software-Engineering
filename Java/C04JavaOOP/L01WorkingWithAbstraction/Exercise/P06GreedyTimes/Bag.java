package L01WorkingWithAbstraction.Exercise.P06GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private Long gold;
    private Map<String, Long> gem;
    private Map<String, Long> cash;
    private Long capacity;
    private long currentCapacity;


    public Bag(long capacity) {
        this.gem = new HashMap<>();
        this.cash = new HashMap<>();
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public void addGold(long quantity) {

    }

    private boolean hasCapacity(long quantity) {
        return currentCapacity + quantity <= currentCapacity;
    }
}
