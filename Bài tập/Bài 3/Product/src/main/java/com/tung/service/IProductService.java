package com.tung.service;

import com.tung.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void delete(int id);
    List<Product> findByName (String name);
}
