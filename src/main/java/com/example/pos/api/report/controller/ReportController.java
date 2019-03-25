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

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/profit")
    public ResponseEntity getReports() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bestseller")
    public ResponseEntity getReport() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/productquantity")
    public ResponseEntity updateReport() {
        return ResponseEntity.ok().build();
    }
}
