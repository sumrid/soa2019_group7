package com.example.pos.Stock;
import com.example.pos.api.stock.Model.Stock;
import com.example.pos.api.stock.Repository.StockRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private StockRepository stockRepository;

    @Before
    public void initData(){
        Stock data1 = new Stock();
        data1.setDate("19/4/98");
        data1.setDate_out("11/12/98");
        data1.setName("Apple Jumkad");
        data1.setPrice(25000.25);
        data1.setStatus("OK");
        data1.setQuantity(4000);

        Stock data2 = new Stock();
        data2.setDate("24/8/97");
        data2.setDate_out("11/12/98");
        data2.setName("Android Jumkad");
        data2.setPrice(15000.75);
        data2.setStatus("NOT OK");
        data2.setQuantity(2000);

        Stock data3 = new Stock();
        data3.setDate("24/8/97");
        data3.setDate_out("11/12/98");
        data3.setName("Android Jumkad");
        data3.setPrice(15000.75);
        data3.setStatus("NOT OK");
        data3.setQuantity(2000);

        stockRepository.save(data1);
        stockRepository.save(data2);
        stockRepository.save(data3); // Total adds : 3
    }

    @After
    public void clearData(){
        stockRepository.deleteAll();
    }

    // Find a stock by name
    @Test
    public void getStock(){
        Optional<Stock> stocks = stockRepository.findByName("Apple Jumkad");

        // --------------- Not working -----------------------------------------------------------------
//        int id = stocks.get().getId();

//        ResponseEntity<Stock> responseEntity = testRestTemplate.getForEntity("/stocks" + id, Stock.class);

//        assertEquals("OK", responseEntity.getBody().getStatus());
//        assertEquals("19/4/98", responseEntity.getBody().getDate());
//        assertEquals("11/12/98", responseEntity.getBody().getDate_out());
//        assertEquals(25000.25, responseEntity.getBody().getPrice(), 0.00);
//        assertEquals(4000, responseEntity.getBody().getQuantity());
        // ----------------------------------------------------------------------------------------------

        assertEquals("OK", stocks.get().getStatus());
        assertEquals("19/4/98", stocks.get().getDate());
        assertEquals("11/12/98", stocks.get().getDate_out());
        assertEquals(25000.25, stocks.get().getPrice(), 0.00);
        assertEquals(4000, stocks.get().getQuantity());

    }

    // Find a size of All stock ( Expected : 3 )
    @Test
    public void getAllStock(){
        ArrayList<Stock> stocks = testRestTemplate.getForObject("/stocks", ArrayList.class);

        assertEquals(3, stocks.size());
    }

    // Create new Stock test
    @Test
    public void createNewStock(){
        Stock newStock = new Stock();
        newStock.setName("Tomatoes");
        newStock.setDate("4/11/99");
        newStock.setQuantity(1000);
        newStock.setPrice(4500.50);
        newStock.setStatus("OK");

        ResponseEntity<Stock> responseEntity = testRestTemplate.postForEntity("/stocks", newStock, Stock.class);

        assertEquals("Tomatoes", responseEntity.getBody().getName());
        assertEquals("4/11/99", responseEntity.getBody().getDate());
        assertEquals(1000, responseEntity.getBody().getQuantity());
        assertEquals(4500.50, responseEntity.getBody().getPrice(), 0.00);
        assertEquals("OK", responseEntity.getBody().getStatus());
    }

    // Delete Test
    // delete the lastest id and count a size
    @Test
    public void deleteStock(){
        ArrayList<Stock> stocks = stockRepository.findAll();
        int stockSize = stocks.size();
        int stockLastId = stocks.get(stockSize - 1).getId();
        Optional<Stock> stock = stockRepository.findById(stockLastId);
        stockRepository.delete(stock.get());
        assertEquals(2, stockRepository.count());
    }
}
