package com.mypc.jwt.securiy.service.impl;

import com.mypc.jwt.securiy.dtos.QuantityDto;
import com.mypc.jwt.securiy.model.Product;
import com.mypc.jwt.securiy.repository.ProductRepository;
import com.mypc.jwt.securiy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;
    @Override
    public Iterable<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        Optional<Product> products = repository.findById(id);
        return products.orElse(null);
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product update(Product product, Integer id) {
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Product increment(Integer id, QuantityDto toIncrement) {
        Product product = verifyIfExist(id);

        product.setQuantity(product.getQuantity() + toIncrement.getQuantity());
        return  repository.save(product);
    }

    @Override
    public Product decrement(Integer id, QuantityDto toDecrement) {
        Product product = verifyIfExist(id);

        if(toDecrement.getQuantity() <= product.getQuantity()){
            product.setQuantity(product.getQuantity() - toDecrement.getQuantity());

            return  repository.save(product);
        }

        return null;
    }

    private Product verifyIfExist(Integer id){
        return repository.findById(id).orElse(null);
    }
}
