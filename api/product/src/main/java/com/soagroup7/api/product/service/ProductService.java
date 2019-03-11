package com.soagroup7.api.product.service;

import com.soagroup7.api.product.model.Product;
import com.soagroup7.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> retrieveProduct(){
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> retrieveProduct(Long id){
        return productRepository.findById(id);
    }

    public Product retrieveProduct(String name){
        return productRepository.findByName(name);
    }

    public Product saveProduct(Product product){
        product.setId(null);
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product product){
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()){
            return productOptional;
        }
        product.setId(id);
        return Optional.of(productRepository.save(product));
    }

    public boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;

        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }

}
