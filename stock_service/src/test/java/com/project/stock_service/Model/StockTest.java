package com.project.stock_service.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class StockTest {
    @Test
    public void testCreateObject() {
        Date date = new Date();
        Stock stock = new Stock(1, "stock", date, 100, 1500, 1);

        assertEquals(1, stock.getId());
        assertEquals("stock", stock.getName());
        assertEquals(date, stock.getDate());
        assertEquals(100, stock.getQuantity());
        assertEquals(1500, stock.getPrice(), 0.00);
        assertEquals(1, stock.getProductId());
    }
}