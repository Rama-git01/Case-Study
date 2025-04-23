package com.customers.service;

import java.util.List;

import com.customers.entity.Customer;
import com.customers.entity.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.client.ProductClient;
import com.customers.entity.Customer;
import com.customers.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository repository;
    private ProductClient productClient;

    @Autowired
    public CustomerService(CustomerRepository repository, ProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    public Product getProductById(long productId) {
    	return productClient.getProductById(productId);
    }

    public void addProductToCustomer(Long customerId, long productId) {
    	Customer customer = getCustomerById(customerId);
    	Product product = getProductById(productId);
    	customer.addProduct(product);
    	repository.save(customer); // Save the updated customer entity
    }


    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existing = getCustomerById(id);
        existing.setFullName(updatedCustomer.getFullName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setPhone(updatedCustomer.getPhone());
        existing.setAddress(updatedCustomer.getAddress());
        existing.setProducts(updatedCustomer.getProducts());
        return repository.save(existing);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
