package com.sumrid_k.Bill.Service.bill_service.repository;

import com.sumrid_k.Bill.Service.bill_service.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
    Bill findBillById(int id);
}
