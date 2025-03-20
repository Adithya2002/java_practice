package Products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockManagerTest {
    @Test
    public void restockTesting(){
        StockManager sm = new StockManager(20);
        sm.restock(20);
        assertEquals(40,sm.getStock() );
    }

}