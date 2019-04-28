package com.project.report_service.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.report_service.model.Bill;
import com.project.report_service.model.Product;
import com.project.report_service.model.Report;
import com.project.report_service.model.Stock;
import com.project.report_service.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private Gson gson;
    @Autowired
    private ReportRepository reportRepository;

    public void getDataAllServices() {
        // get data from each service
        ResponseEntity responseBills = restTemplate.getForEntity("http://localhost:8080/bills", ArrayList.class);
        ResponseEntity responseProducts = restTemplate.getForEntity("http://localhost:8080/product", ArrayList.class);
        ResponseEntity responseStocks = restTemplate.getForEntity("http://localhost:8080/stocks", ArrayList.class);

        // convert json to object
        Type type1 = new TypeToken<ArrayList<Bill>>() {
        }.getType();
        ArrayList<Bill> bills = gson.fromJson(responseBills.getBody().toString(), type1);

        Type type2 = new TypeToken<ArrayList<Stock>>() {
        }.getType();
        ArrayList<Stock> stocks = gson.fromJson(responseStocks.getBody().toString(), type2);

        Type type3 = new TypeToken<List<Product>>() {
        }.getType();
        List<Product> products = gson.fromJson(responseProducts.getBody().toString(), type3);

        // new report
        Report report = new Report();
        report.setDate(new Date());
        report.setBestseller(findBestSeller(bills));
        report.setLowInventory(findLowInventory(stocks));
        report.setIncome(calculateIncome(bills));
        report.setProfit(calculateProfit());

        // save to database...
        reportRepository.save(report);
    }

    public List<Report> getReport() {
        List<Report> reports = reportRepository.findAll();
        return reports;
    }

    private long findBestSeller(ArrayList<Bill> bills) {
        long tmpProduct = 0;
        int tmpAmount = 0;

        for (Bill bill : bills) {
            if (bill.getAmount() > tmpAmount) {
                tmpProduct = bill.getId();
            }
        }

        return tmpProduct;
    }

    private long findLowInventory(ArrayList<Stock> stocks) {
        long tempProduct = 0;
        int tmpInventory = Integer.MAX_VALUE;
        for (Stock stock : stocks) {
            if (stock.getQuantity() < tmpInventory) {
                tempProduct = stock.getProductId();
            }
        }

        return tempProduct;
    }

    private double calculateIncome(ArrayList<Bill> bills) {
        double totalIncome = 0;

        for(Bill bill : bills) {
            totalIncome += bill.getTotalPrice();
        }

        return totalIncome;
    }

    private double calculateProfit() {
        return 45.4;
    }
}
