package Products;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Product management
//        ProductManager pm = new ProductManager();
//        Product p1 = new Product(0,"p1", 450);
//        Product p2 = new Product(0,"p2", 1000);
//        Product p3 = new Product(0,"p3", 700);
//        Product p4 = new Product(0,"p4", 800);
//        Product p5 = new Product(0,"p5", 550);
//        pm.addProduct(p1);
//        pm.addProduct(p2);
//        pm.addProduct(p3);
//        pm.addProduct(p4);
//        pm.addProduct(p5);
//        System.out.println(pm.getExpensiveProducts());

        //Stock Management via threading
//        StockManager stockManager = new StockManager(100);
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    stockManager.stockUpdater(50);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            try {
//                stockManager.stockUpdater(-30);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        });
//        Thread t3 = new Thread(() -> {
//            try{
//                stockManager.stockUpdater(20);
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try{
//            t1.join();
//            t2.join();
//            t3.join();
//        }
//        catch(InterruptedException e){
//            throw new InterruptedException();
//        }
//        stockManager.saveStockToFile();
//        System.out.println("Number of times updated "+ stockManager.totalUpdates);
//        System.out.println("Final stock: " + stockManager.getStock());

        List<Integer> updates = Arrays.asList(50,20,-30);
        StockPriorityQueue sPQ = new StockPriorityQueue(updates);
    }
}
