package com.sumrid_k.pos.Report.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sumrid_k.pos.Report.model.Bill;
import com.sumrid_k.pos.Report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index.html");
        return view;
    }

    @GetMapping("/reports")
    public ResponseEntity getReport() {
        return ResponseEntity.ok(reportService.getReports());
    }

    // FOR TEST | GET DATA FROM ALL SERVICES
    @GetMapping("/get-all-data")
    @HystrixCommand(fallbackMethod = "fallbackGetAllData")
    public String  getData() {
        reportService.getDataAllServices();
        return "Success";
    }

    @GetMapping("/testbill")
    public ResponseEntity getBill() {
        return restTemplate.getForEntity("http://bill-service/bills", Object.class);
    }

    @PostMapping("/save-bill")
    public ResponseEntity sageBill(@RequestBody Bill bill) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bill);
    }

    public String fallbackGetAllData() {
        return "Please try again.";
    }

    public ResponseEntity fallbackGetBill() {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Please try agail.");
    }
}
