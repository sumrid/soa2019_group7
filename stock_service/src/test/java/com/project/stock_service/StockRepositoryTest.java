package com.project.stock_service;


import com.project.stock_service.Model.Stock;
import com.project.stock_service.Repository.StockRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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
        data1.setDate(new Date());
        data1.setName("Apple Jumkad");
        data1.setPrice(25000.25);
        data1.setQuantity(4000);
        data1.setProductId(12907);

        entityManager.persist(data1);
        
    }

    @After
    public void clearData(){
        stockRepository.deleteAll();
    }

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
