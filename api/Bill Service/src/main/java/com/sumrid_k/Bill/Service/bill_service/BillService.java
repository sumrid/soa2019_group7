package com.sumrid_k.Bill.Service.bill_service;

import com.sumrid_k.Bill.Service.bill_service.model.Bill;
import com.sumrid_k.Bill.Service.bill_service.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill getBill(int id){
        return billRepository.findBillById(id);
    }

    public ArrayList<Bill> getAll(){
        Iterator<Bill> dataSet = billRepository.findAll().iterator();
        ArrayList<Bill> bills = new ArrayList<>();
        while (dataSet.hasNext()){
            bills.add(dataSet.next());
        }
        return bills;
    }

    public void saveBill(Bill bill){
        billRepository.save(bill);
    }
}
