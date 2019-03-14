package com.sumrid_k.Bill.Service.bill_service.repository;

import com.sumrid_k.Bill.Service.bill_service.model.Bill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class BillRepositoryTest {
    @Autowired
    private BillRepository billRepository;

    @Test
    public void successFindById(){
        // Initial data in database
        Bill bill = new Bill();
        bill.setDate(new Date());
        bill.setAmount(1);
        bill.setTotalPrice(45.4);
        bill.setCompanyName("test co.");
        billRepository.save(bill);

        // Find by id
        Optional<Bill> result = billRepository.findById(1);

        // Assert
        assertEquals("test co.", result.get().getCompanyName());
    }
}