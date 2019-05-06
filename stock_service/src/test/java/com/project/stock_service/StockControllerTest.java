package com.project.stock_service;

import com.project.stock_service.Controller.StockController;
import com.project.stock_service.Model.Stock;
import com.project.stock_service.Service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

    @Mock
    private RestTemplate restTemplateMock;
    @Mock
    private StockService stockServiceMock;

    @Spy
    @InjectMocks
    private StockController stockControllerMock;

    // Find a size of All stock ( Expected : 3 )
    @Test
    public void getAllStock() {
        ArrayList<Stock> output = new ArrayList<>();
        output.add(new Stock());
        output.add(new Stock());
        output.add(new Stock());
        when(stockServiceMock.getAll()).thenReturn(output);

        ArrayList<Stock> stocks = stockControllerMock.getStocks();

        assertEquals(3, stocks.size());
    }

    // Create new Stock test
    @Test
    public void createNewStock() throws ParseException {
        Stock newStock = new Stock();
        newStock.setName("Tomatoes");
        newStock.setDate((new SimpleDateFormat("yyyy-MM-dd")).parse("2019-05-04"));
        newStock.setQuantity(1000);
        newStock.setPrice(4500.50);
        newStock.setProductId(12301);

        doNothing().when(stockServiceMock).saveStock(any(Stock.class));
        when(restTemplateMock.postForObject(anyString(), any(Stock.class), any()))
                .thenReturn(null);

        ResponseEntity<Stock> responseEntity = stockControllerMock.createStock(newStock);

        assertEquals("Tomatoes", responseEntity.getBody().getName());
        assertEquals((new SimpleDateFormat("yyyy-MM-dd")).parse("2019-05-04"), responseEntity.getBody().getDate());
        assertEquals(1000, responseEntity.getBody().getQuantity());
        assertEquals(4500.50, responseEntity.getBody().getPrice(), 0.00);
        assertEquals(12301, responseEntity.getBody().getProductId());
    }

    // Delete Test
    // delete the lastest id and count a size
    @Test
    public void deleteStock() {
        when(stockServiceMock.deleteStock(eq(5))).thenReturn(true);

        stockControllerMock.deleteStock(5);
    }
}
