package com.example.pos.api.stock.Controller;

import com.example.pos.api.stock.Model.Stock;
import com.example.pos.api.stock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    // Get all stock
    @GetMapping("/stocks")
    public ArrayList<Stock> getStocks() {return stockService.getAll();}

    // Get a Stock by ID
    @GetMapping("/stocks/{id}")
    public Stock getStock(@PathVariable int id) {return stockService.getStock(id);}

    // New Stock
    @PostMapping("/stocks")
    public ResponseEntity createStock(@RequestBody Stock stock){
        stockService.saveStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(stock);
    }

    // Update Stock
    @PutMapping("/stocks/{id}")
    public ResponseEntity updateStock(@PathVariable int id,@RequestBody Stock stock){
        stockService.updateStock(id, stock);
        return ResponseEntity.ok().build();
    }

    // Delete Stock
    @DeleteMapping("/stocks/{id}")
    public ResponseEntity deleteStock(@PathVariable int id){
        boolean stockDeleted = stockService.deleteStock(id);
        if (stockDeleted){
            return new ResponseEntity("Stock deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity("Fail", HttpStatus.NOT_FOUND);
        }
    }

}
