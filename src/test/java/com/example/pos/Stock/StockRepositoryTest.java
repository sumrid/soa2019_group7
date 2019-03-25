package com.example.pos.Stock;

import com.example.pos.api.stock.Model.Stock;
import com.example.pos.api.stock.Repository.StockRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Stock data1;

    @Before
    public void initData(){
        data1 = new Stock();
        data1.setDate_in("19/4/98");
        data1.setDate_out("11/12/98");
        data1.setName("Apple Jumkad");
        data1.setPrice(25000.25);
        data1.setStatus("OK");
        data1.setQuantity(4000);
        data1.setProductId(12907);

        entityManager.persist(data1);
        
    }

    @After
    public void clearData(){
        stockRepository.deleteAll();
    }

    @Test
    public void findById(){

        Optional<Stock> stock = stockRepository.findById(data1.getId());
        assertThat(stock.get().equals(data1));

    }

    @Test
    public void findByName(){

        Optional<Stock> stock = stockRepository.findByName(data1.getName());
        assertThat(stock.get().equals(data1));

    }


}
