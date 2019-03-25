package com.example.pos.Stock;

import com.example.pos.api.stock.Model.Stock;
import com.example.pos.api.stock.Repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Before
    public void initData(){
        Stock data1 = new Stock();
        data1.setDate_in("19/4/98");
        data1.setDate_out("11/12/98");
        data1.setName("Apple Jumkad");
        data1.setPrice(25000.25);
        data1.setStatus("OK");
        data1.setQuantity(4000);
        data1.setProductId(12907);

        Stock data2 = new Stock();
        data2.setDate_in("24/8/97");
        data2.setDate_out("11/12/98");
        data2.setName("Android Jumkad");
        data2.setPrice(15000.75);
        data2.setStatus("NOT OK");
        data2.setQuantity(2000);
        data2.setProductId(12908);

        stockRepository.save(data1);
        stockRepository.save(data2);
    }

    @Test
    public void findById(){
        Stock stock = stockRepository.findById(1).get();
        assertEquals(2, stock.getId());
        assertEquals("Android Jumkad", stock.getName());
        assertEquals("24/8/97", stock.getDate_in());
        assertEquals("11/12/98", stock.getDate_out());
        assertEquals(15000.75, stock.getPrice(), 0.00);
        assertEquals("NOT OK", stock.getStatus());
        assertEquals(2000, stock.getQuantity());
        assertEquals(12908, stock.getProductId());
    }

    @Test
    public void findByName(){
        Stock stock = stockRepository.findByName("Apple Jumkad").get();
        assertEquals("19/4/98", stock.getDate_in());
        assertEquals("11/12/98", stock.getDate_out());
        assertEquals(25000.25, stock.getPrice(), 0.00);
        assertEquals("OK", stock.getStatus());
        assertEquals(4000, stock.getQuantity());
        assertEquals(12907, stock.getProductId());
    }


}
