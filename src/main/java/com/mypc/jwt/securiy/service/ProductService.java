package com.mypc.jwt.securiy.service;

import com.mypc.jwt.securiy.dtos.QuantityDto;
import com.mypc.jwt.securiy.model.Product;


public interface ProductService {

    Iterable<Product> getAll();

    Product getById(Integer id);

    Product create(Product product);

    Product update(Product product, Integer id);

    void delete(Integer id);

    Product increment(Integer id, QuantityDto toIncrement);

    Product decrement(Integer id, QuantityDto toDecrement);




}
