package com.oasong.stock.controller;

import com.oasong.stock.model.Stock;
import com.oasong.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StockController {

    @Autowired
    StockService stockService = new StockService();

    @GetMapping("/stocks")
    public ArrayList<Stock> getStocks(){
        return stockService.getAll();
    }

    @GetMapping("/stocks/{id}")
    public Stock getStock(@PathVariable int id){
        return stockService.getId(id);
    }

    @PostMapping("/stocks")
    public String newStock(@RequestAttribute Stock stock){
        stockService.saveStock(stock);
        return "Hello";
    }
}
