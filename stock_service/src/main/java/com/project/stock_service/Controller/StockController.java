package com.example.pos.api.stock.Controller;

import com.example.pos.api.stock.Model.Stock;
import com.example.pos.api.stock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    // Get all stock
    @GetMapping("/stocks")
    public ArrayList<Stock> getStocks() {return stockService.getAll();}

    // Get a Stock by ID
    @GetMapping("/stocks/{id}")
    public ResponseEntity<Object> getStock(@PathVariable int id) {
        Optional<Stock> stock = stockService.getStock(id);
        if (!stock.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stock);}

    // New Stock
    @PostMapping("/stocks")
    public ResponseEntity createStock(@RequestBody Stock stock){
        stockService.saveStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(stock);
    }

    // Update Stock
    @PutMapping("/stocks/{id}")
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
    public ResponseEntity deleteStock(@PathVariable int id){
        boolean stockDeleted = stockService.deleteStock(id);
        if (stockDeleted){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
