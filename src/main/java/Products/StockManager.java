package Products;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.text.SimpleDateFormat;
import java.util.Date;


public class StockManager {
    int stock;
    public int totalUpdates=0;
    String filePath = "persistenceStorage/stock.txt";
    private static final Logger logger = LoggerFactory.getLogger(StockManager.class);

    
    public StockManager(){
        if(loadStockFromFile()==null){
            this.stock = 0;
        }
        else{
            this.stock = loadStockFromFile();
        }
    }
    public StockManager(int stock){
        this.stock = stock;
        System.out.println("Initial stock: " + stock);
    }
    public int getStock() {
        return stock;
    }

    public synchronized void stockUpdater(int amount) throws Exception {
        totalUpdates++;
        if(amount>=0){
            addStock(amount);
        }
        else{
            removeStock(amount);
            restock(20);
        }

    }
    public synchronized void addStock(int amount) {

        this.stock += amount;
        System.out.println(Thread.currentThread().getName() + ": Added " + amount + ", New stock: " + this.stock);
    }
    public synchronized void removeStock(int amount) throws Exception {

        if(amount>stock){
            throw new Products.InsufficientStockException(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " Cannot remove " + amount + ", only " + this.stock +  " available");
        }
        this.stock += amount;
        System.out.println(Thread.currentThread().getName() + ": Removed " + -amount + ", New stock: " + this.stock);
    }
    public synchronized int restock(int amount)  {
        int threshold = 50;
        if (stock < threshold) {
            addStock(amount);
            logger.info("Restocked {}, new stock {}",amount, this.stock);
//            System.out.println(Thread.currentThread().getName() + ": Restocked " + amount + ", new stock: " + stock);
        }
        return this.stock;
    }

    public void saveStockToFile(){
        File file = new File(filePath);
        try{
            file.getParentFile().mkdirs();
            Files.writeString(Paths.get(filePath), Integer.toString(this.stock));
            System.out.println("Value written to file successfully");
        }
        catch( IOException e){
            System.out.println("Error saving to file");
            System.out.println(e.getMessage());
        }
    }
    public Integer loadStockFromFile(){
        try{
            if(!Files.exists(Paths.get(filePath))){
                System.out.println("File does not exist! Creating one");
                return null;
            }
            this.stock = Integer.parseInt(Files.readString(Paths.get(filePath)));
            return this.stock;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
            return null;
        }
    }

}
