package com.project.bill_service.repository;

import com.project.bill_service.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
    ArrayList<Bill> findByCompanyName(String companyName);
    ArrayList<Bill> findAll();
}
