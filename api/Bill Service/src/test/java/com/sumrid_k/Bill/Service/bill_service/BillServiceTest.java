package com.sumrid_k.Bill.Service.bill_service;

import com.sumrid_k.Bill.Service.bill_service.model.Bill;
import com.sumrid_k.Bill.Service.bill_service.repository.BillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceTest {

    @Mock
    BillRepository billRepository;

    @Test
    public void findById(){
        Bill billStub = new Bill();
        billStub.setDate(new Date());
        billStub.setCompanyName("test co.");
        billStub.setAmount(1);
        billStub.setTotalPrice(19.9);


    }
}