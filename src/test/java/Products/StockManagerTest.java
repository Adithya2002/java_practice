package Products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockManagerTest {
    @Test
    public void restockTesting(){
        StockManager sm = new StockManager(20);
        assertEquals(sm.getStock()+20, sm.restock(20));

    }

}