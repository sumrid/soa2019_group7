package com.sumrid_k.Bill.Service.bill_service;

import com.sumrid_k.Bill.Service.bill_service.model.Bill;
import com.sumrid_k.Bill.Service.bill_service.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    // get by id
    public Bill getBill(int id){
        return billRepository.findBillById(id);
    }

    // get all bills
    public ArrayList<Bill> getAll(){
        Iterator<Bill> dataSet = billRepository.findAll().iterator();
        ArrayList<Bill> bills = new ArrayList<>();

        while (dataSet.hasNext()){
            bills.add(dataSet.next());
        }
        return bills;
    }

    // save
    public void saveBill(Bill bill){
        billRepository.save(bill);
    }

    // delete
    public boolean deleteBill(int id) {
        Optional<Bill> bill = billRepository.findById(id);

        if(bill.isPresent()){
            billRepository.delete(bill.get());
            return true;
        } else {
            return false;
        }
    }

    // update
    public boolean updateBill(int id, Bill bill) {
        Optional<Bill> billOptional = billRepository.findById(id);

        if(billOptional.isPresent()){
            bill.setId(id);
            billRepository.save(bill);
            return true;
        } else {
            return false;
        }
    }
}
