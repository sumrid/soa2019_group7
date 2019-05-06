package com.sumrid_k.pos.Bill.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductTest {

    @Test
    public void testCreateObject() {
        Product product = new Product();

        product.setId(1l);
        product.setDetail("detail");
        product.setName("name");
        product.setPrice(199.99);
        product.setQuantity(2000);
        product.setImg("image.jpg");

        assertEquals(1, product.getId(), 0.00);
        assertEquals("name", product.getName());
        assertEquals("detail", product.getDetail());
        assertEquals(199.99, product.getPrice(), 0.00);
        assertEquals(2000, product.getQuantity());
        assertEquals("image.jpg", product.getImg());
    }
}