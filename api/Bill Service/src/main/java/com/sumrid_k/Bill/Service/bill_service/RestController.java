package com.sumrid_k.Bill.Service.bill_service;

import com.sumrid_k.Bill.Service.bill_service.model.Bill;
import com.sumrid_k.Bill.Service.bill_service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    BillService billService = new BillService();

    @GetMapping("/bills")
    public ArrayList<Bill> getBills(){
        return billService.getAll();
    }

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable int id){
        return billService.getBill(id);
    }

    @PostMapping("/bills")
    public String createBill(@RequestBody Bill bill){
        billService.saveBill(bill);
        return "Successful transaction";
    }
}
