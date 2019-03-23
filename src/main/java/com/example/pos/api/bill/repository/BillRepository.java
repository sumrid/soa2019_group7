package com.example.pos.api.bill.repository;

import com.example.pos.api.bill.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
    ArrayList<Bill> findByCompanyName(String companyName);
    ArrayList<Bill> findAll();
}
