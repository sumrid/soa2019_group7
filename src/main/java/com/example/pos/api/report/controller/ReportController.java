package com.example.pos.api.report.controller;

import com.example.pos.api.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping()
    public ResponseEntity getReport() {
        return ResponseEntity.ok(reportService.getReport());
    }

    // for get data from all service
    // for test
    @GetMapping("/getdata")
    public void getData() {
        reportService.getDataAllServices();
    }

//    @GetMapping("/profit")
//    public ResponseEntity getProfit() {
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/bestseller")
//    public ResponseEntity getBestSeller() {
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/productquantity")
//    public ResponseEntity updateReport() {
//        return ResponseEntity.ok().build();
//    }
}
