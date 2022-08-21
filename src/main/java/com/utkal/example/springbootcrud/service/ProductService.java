package com.utkal.example.springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkal.example.springbootcrud.entity.Product;
import com.utkal.example.springbootcrud.repository.ProductRepository;

@Service
public class ProductService  {

	@Autowired
	private ProductRepository productRepository;
	
	//POST
	//save one product to the database(MySql table)
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//POST
	//save list of product to the database(MySql table)
	public List<Product> saveAllProduct(List<Product> listOfProduct) {
		return productRepository.saveAll(listOfProduct);
		}
	
	//GET
	//Fetch Product by Id
	public Product getProductById(Integer id) {	
		return productRepository.findById(id).get();
	}
	
	//GET
	//Fetch List of Products
	public List<Product> getAllProducts() {	
		return productRepository.findAll();
	}
	
	//GET
	//Fetch Product by name
	public List<Product> getProductByName(String name) {
		return productRepository.findByName(name);
	}
	
	//DELETE
	//Delete a product by Id
	public String deleteProduct(int id) {
		 productRepository.deleteById(id);
		 return "Product removed : "+id;
	}
	
	//UPDATE
	//Update a Product Detail
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}
	
	
}
