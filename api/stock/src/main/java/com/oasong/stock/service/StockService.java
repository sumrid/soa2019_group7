package com.oasong.stock.service;

import com.oasong.stock.model.Stock;
import com.oasong.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock getId(int id){
        return stockRepository.findStockById(id);
    }

    public ArrayList<Stock> getAll(){
        Iterator<Stock> dataSet = stockRepository.findAll().iterator();
        ArrayList<Stock> stocks = new ArrayList<>();
        while (dataSet.hasNext()){
            stocks.add(dataSet.next());
        }
        return stocks;
    }

    public void saveStock(Stock stock){
        stockRepository.save(stock);
    }


}
