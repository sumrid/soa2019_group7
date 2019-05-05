package com.project.stock_service.Controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.stock_service.Model.Stock;
import com.project.stock_service.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    // Get all stock
    @GetMapping("/stocks")
    @HystrixCommand(fallbackMethod = "fallbackGetStocks")
    public ArrayList<Stock> getStocks() {
        return stockService.getAll();
    }

    // Get a Stock by ID
    @GetMapping("/stocks/{id}")
    @HystrixCommand(fallbackMethod = "fallbackGetStock")
    public ResponseEntity getStock(@PathVariable int id) {
        Optional<Stock> stock = stockService.getStock(id);
        if (!stock.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stock);}

    // New Stock
    @PostMapping("/stocks")
    @HystrixCommand(fallbackMethod = "fallbackCreateStock")
    public ResponseEntity createStock(@RequestBody Stock stock){
        stockService.saveStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(stock);
    }

    // Update Stock
    @PutMapping("/stocks/{id}")
    @HystrixCommand(fallbackMethod = "fallbackUpdateStock")
    public ResponseEntity updateStock(@PathVariable int id,@RequestBody Stock stock){
        boolean stockUpdate = stockService.updateStock(id, stock);
        if (stockUpdate){
            return ResponseEntity.status(HttpStatus.OK).body(stock);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Stock
    @DeleteMapping("/stocks/{id}")
    @HystrixCommand(fallbackMethod = "fallbackDeleteStock")
    public ResponseEntity deleteStock(@PathVariable int id){
        boolean stockDeleted = stockService.deleteStock(id);
        if (stockDeleted){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public ArrayList<Stock> fallbackGetStocks() {
        ArrayList<Stock> stocks = new ArrayList<>();
        Stock stock = new Stock();
        stock.setName("Request fails.");
        stock.setStatus("Please try again.");
        stocks.add(stock);
        return stocks;
    }

    public ResponseEntity fallbackGetStock(int id) {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Please try again.");
    }

    public ResponseEntity fallbackCreateStock(Stock stock) {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Please try again.");
    }

    public ResponseEntity fallbackUpdateStock(int id, Stock stock) {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Please try again.");
    }

    public ResponseEntity fallbackDeleteStock(int id) {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Please try again.");
    }
}