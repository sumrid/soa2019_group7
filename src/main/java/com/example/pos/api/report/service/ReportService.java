package com.example.pos.api.report.service;

import com.example.pos.api.bill.model.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.BitSet;

@Service
public class ReportService {

    private RestTemplate restTemplate = new RestTemplate();

    public void getDataAllServices() {
        ResponseEntity responseBills = restTemplate.getForEntity("http://localhost:8080/bills", ArrayList.class);
        ResponseEntity responseProducts = restTemplate.getForEntity("http://localhost:8080/product", ArrayList.class);
        ResponseEntity responseStocks = restTemplate.getForEntity("http://localhost:8080/stocks", ArrayList.class);


        // save to database...

    }
}
