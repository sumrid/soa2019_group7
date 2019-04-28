package com.project.bill_service.controller;;


import com.project.bill_service.model.Bill;
import com.project.bill_service.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/bills")
    public ArrayList<Bill> getBills(){
        return billService.getAll();
    }

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable int id){
        return billService.getBill(id);
    }

    @PostMapping("/bills")
    public ResponseEntity createBill(@RequestBody Bill bill){
        billService.saveBill(bill);
        return ResponseEntity.status(HttpStatus.CREATED).body(bill);
    }

    @PutMapping("/bills/{id}")
    public ResponseEntity updateBills(@PathVariable int id, @RequestBody Bill bill){
        billService.updateBill(id, bill);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/bills/{id}")
    public ResponseEntity deleteBills(@PathVariable int id){
        boolean isDeleted = billService.deleteBill(id);
        if(isDeleted) {
            return new ResponseEntity("Bill is deleted successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity("Deleted fail", HttpStatus.NOT_FOUND);
        }
    }
}
