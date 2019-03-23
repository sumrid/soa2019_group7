package com.example.pos.api.bill;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.pos.api.bill.controller.BillController;
import com.example.pos.api.bill.model.Bill;
import com.example.pos.api.bill.repository.BillRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private BillRepository billRepository;

    @Before
    public void initData() {
        Bill demo1 = new Bill();
        demo1.setAmount(12);
        demo1.setCompanyName("demo1 inc.");
        demo1.setTotalPrice(199.99);

        Bill demo2 = new Bill();
        demo2.setAmount(1);
        demo2.setCompanyName("demo2 inc.");
        demo2.setTotalPrice(29.9);

        billRepository.save(demo1);
        billRepository.save(demo2);
    }

    @Test
    public void getBill() {
        Bill bill = testRestTemplate.getForObject("/bills/1", Bill.class);

        assertEquals("demo1 inc.", bill.getCompanyName());
        assertEquals(1, bill.getId());
    }

    @Test
    public void getBills() {
        ArrayList<Bill> bills = testRestTemplate.getForObject("/bills", ArrayList.class);
        assertEquals(2, bills.size());
    }

    @Test
    public void createBill() {
        Bill request = new Bill();
        request.setTotalPrice(13.5);
        request.setCompanyName("post com");
        request.setAmount(1);

        ResponseEntity<Bill> responseEntity = testRestTemplate.postForEntity("/bills", request, Bill.class);

        assertEquals("post com", responseEntity.getBody().getCompanyName());
        assertEquals(13.5, responseEntity.getBody().getTotalPrice(), 0.000);
    }

    @Test
    public void deleteBill() {
        // get id of last object
        ArrayList<Bill> result = billRepository.findAll();
        int idOfLastBill = result.get(result.size() - 1).getId();

        // delete
        testRestTemplate.delete("/bills/" + idOfLastBill);

        // assert
        assertEquals(1, billRepository.count());
    }

    @After
    public void clearData() {
        billRepository.deleteAll();
    }
}