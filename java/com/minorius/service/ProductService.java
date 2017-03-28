package com.minorius.service;

import com.minorius.entity.Category;
import com.minorius.entity.Product;
import com.minorius.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minorius on 20.03.2017.
 */

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List getAllProductByCategory(String nameOfCategory){
        return productRepository.getAllProductByCategory(nameOfCategory);
    }

    public void addProductByCategory(Product product, String name){
        productRepository.addProductByCategory(product, name);
    }
}
