package com.customers.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customers.entity.Product;

@FeignClient(name = "product-service")
public interface ProductClient {

	@GetMapping("/products/{productId}")
	Product getProductById(@PathVariable("productId") long productId);
}




