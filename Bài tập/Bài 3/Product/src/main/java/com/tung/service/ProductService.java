package com.tung.service;

import com.tung.controller.ProductController;
import com.tung.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Sting",8000));
        products.add(new Product(2,"Coca",10000));
        products.add(new Product(3,"Pepsi",9000));
        products.add(new Product(4,"Tiger",15000));
        products.add(new Product(5,"Compact",10000));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.set(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }

}
