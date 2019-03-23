package com.example.pos.api.bill;

import com.example.pos.api.bill.model.Bill;
import com.example.pos.api.bill.repository.BillRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BillRepositoryTest {

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
    public void findById() {
        Bill result = billRepository.findById(1).get();

        assertEquals(1, result.getId());
    }

    @Test
    public void findByCompanyName() {
        ArrayList<Bill> bills = billRepository.findByCompanyName("demo1 inc.");
        assertEquals(1, bills.size());
    }
}