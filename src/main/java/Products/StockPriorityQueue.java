package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class StockPriorityQueue {
    PriorityQueue<Integer> stockPQ = new PriorityQueue<>((a, b) -> Math.abs(b) - Math.abs(a));
    List<Integer> updates = new ArrayList<>();
    StockManager stockManager = new StockManager(100);
    public StockPriorityQueue(List<Integer> updates) {
        this.updates = updates;
        queueStock();
        try {
            processUpdates();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queueStock(){
        for(int i:updates){
            stockPQ.add(i);
            System.out.println("Queue size: " + stockPQ.size());
        }

    }
    public void processUpdates() throws Exception {
        while(stockPQ.size()>0){
            stockManager.stockUpdater(stockPQ.poll());
        }
    }

}
