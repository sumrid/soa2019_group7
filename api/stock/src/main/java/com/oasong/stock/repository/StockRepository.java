package com.oasong.stock.repository;

import com.oasong.stock.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer> {
    Stock findStockById(int d);

}
