package com.project.stock_service.Service;

import com.project.stock_service.Model.Stock;
import com.project.stock_service.Repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {
    @Mock
    private StockRepository repositoryMock;
    @Spy
    @InjectMocks
    private StockService stockService;

    private Stock stockMock;
    private Optional<Stock> optionalStock;

    @Before
    public void setUp() {
        stockMock = new Stock();
        stockMock.setDate(new Date());
        stockMock.setName("Apple Jumkad");
        stockMock.setPrice(25000.25);
        stockMock.setQuantity(4000);
        stockMock.setProductId(12907);

        optionalStock = Optional.of(stockMock);
    }

    @Test
    public void testGetStockById() {
        when(repositoryMock.findById(anyInt())).thenReturn(optionalStock);

        Optional<Stock> result = stockService.getStock(1);

        assertEquals(true, result.isPresent());
    }

    @Test
    public void testUpdateStockSuccess() {
        when(repositoryMock.findById(anyInt())).thenReturn(optionalStock);
        when(repositoryMock.save(any(Stock.class))).thenReturn(stockMock);

        boolean result = stockService.updateStock(1, stockMock);

        assertTrue(result);
    }

    @Test
    public void testDeleteStockSuccess() {
        when(repositoryMock.findById(anyInt())).thenReturn(optionalStock);
        doNothing().when(repositoryMock).delete(any(Stock.class));

        boolean result = stockService.deleteStock(1);

        assertTrue(result);
    }
}