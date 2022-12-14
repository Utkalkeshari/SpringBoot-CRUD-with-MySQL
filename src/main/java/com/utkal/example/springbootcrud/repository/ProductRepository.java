package com.utkal.example.springbootcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkal.example.springbootcrud.entity.Product;

public interface ProductRepository extends JpaRepository< Product, Integer>{

	List<Product> findByName(String name);

}
