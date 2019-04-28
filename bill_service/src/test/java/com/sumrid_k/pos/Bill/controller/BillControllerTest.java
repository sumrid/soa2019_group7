package com.sumrid_k.pos.Bill.controller;

import com.sumrid_k.pos.Bill.model.Bill;
import com.sumrid_k.pos.Bill.repository.BillRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillControllerTest {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    private ArrayList<Bill> billList;

    @Before
    public void setUp() {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setDate(new Date());
        bill.setTotalPrice(99.99);
        bill.setCompanyName("Tie the Taught");
        bill.setUserName("sumrid k");

        Bill bil2 = new Bill();
        bil2.setId(2);
        bil2.setDate(new Date());
        bil2.setTotalPrice(200.99);
        bil2.setCompanyName("Barlow and Co");
        bil2.setUserName("Mylee Turnbull");

        billList = new ArrayList<>();
        billList.add(bill);
        billList.add(bil2);

        billRepository.saveAll(billList);
    }

//    @After
    public void clear() {
        billRepository.deleteAll();
    }


    @Test
    public void getBills() {
        ArrayList<Bill> result = restTemplate.getForObject("/bills", ArrayList.class);
        assertEquals(3, result.size());
    }

    @Test
    public void getBill() {
        Bill result = restTemplate.getForObject("/bills/1", Bill.class);

        assertEquals("sumrid k", result.getUserName());
        assertEquals("Tie the Taught", result.getCompanyName());
        assertEquals(99.99, result.getTotalPrice(), 0.00);
    }

    @Test
    public void createBill() {
        Bill request = new Bill();
        request.setId(3);
        request.setDate(new Date());
        request.setTotalPrice(200.99);
        request.setCompanyName("company Inc.");
        request.setUserName("Rora Back");

        Bill response = restTemplate.postForObject("/bills", request, Bill.class);

        assertEquals("Rora Back", response.getUserName());
    }

    @Test
    public void updateBills() {
        Bill request = new Bill();
        request.setDate(new Date());
        request.setTotalPrice(1500);
        request.setCompanyName("724 Solutions Inc.");
        request.setUserName("Rio Tinto");

        restTemplate.put("/bills/1", request);
        Bill response = restTemplate.getForObject("/bills/1", Bill.class);

        assertEquals("Rio Tinto", response.getUserName());
    }

    @Test
    public void deleteBills() {
    }

    private Object jsonToObject(String json) {
        return null;
    }
}