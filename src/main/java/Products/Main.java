package Products;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> updates = Arrays.asList(50,20,-30);
        StockPriorityQueue sPQ = new StockPriorityQueue(updates);
    }
}
