package com.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.entity.Product;
import com.products.repository.ProductRepository;


@Service
public class ProductService {

    private ProductRepository productRepo;
    
    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProductById(long productId) {
        return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(long productId, Product updatedProduct) {
        Product existing = getProductById(productId);
        existing.setProductName(updatedProduct.getProductName());
        existing.setProductPrice(updatedProduct.getProductPrice());
        existing.setProductQuantity(updatedProduct.getProductQuantity());
        return productRepo.save(existing);
    }

    public void deleteProduct(long productId) {
    	productRepo.deleteById(productId);
    }
}
