package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Product;
import com.products.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable long productId) {
		return productService.getProductById(productId);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable long productId, @RequestBody Product updatedProduct) {
		return productService.updateProduct(productId, updatedProduct);
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		productService.deleteProduct(productId);
	}

}
