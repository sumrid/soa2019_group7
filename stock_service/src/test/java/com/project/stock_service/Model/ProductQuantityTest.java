package com.project.stock_service.Model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class ProductQuantityTest {

    @Test
    public void testCreateObject() {
        ProductQuantity object = new ProductQuantity("name", 1, 111.11, 1);

        assertEquals("name", object.getName());
        assertEquals(1, object.getQuantity());
        assertEquals(111.11, object.getPrice(), 0.00);
        assertEquals(1, object.getProductId());
    }

    @Test
    public void testCreateObject2() {
        ProductQuantity oject = new ProductQuantity();
        oject.setId(1);
        oject.setName("name");
        oject.setQuantity(900);
        oject.setPrice(100.99);
        oject.setProductId(1);

        assertEquals(1, oject.getId());
        assertEquals("name", oject.getName());
        assertEquals(900, oject.getQuantity());
        assertEquals(100.99, oject.getPrice(), 0.00);
        assertEquals(1, oject.getProductId());
    }
}