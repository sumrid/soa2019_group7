package com.example.pos.Product;

import com.example.pos.api.product.model.Product;
import com.example.pos.api.product.repository.ProductRepository;
import com.example.pos.api.product.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {


    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        productService = new ProductService(productRepository);
    }

    @Test
    public void productSaveSuccess() throws Exception {
        //setdata
        doAnswer(returnsFirstArg()).when(productRepository).save(any(Product.class));
        Product test = new Product();
        test.setName("ProductName1");
        test.setDetail("PD detail1");
        test.setPrice(1000);
        test.setQuantity(10);
        test.setImg("PD1 Link img");

        //when
        Product pdRespone = productService.saveProduct(test);

        //then
        assertThat(pdRespone).isEqualTo(test);
        verify(productRepository).save(any(Product.class));
    }


}
