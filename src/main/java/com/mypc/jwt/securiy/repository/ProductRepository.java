package com.mypc.jwt.securiy.repository;

import com.mypc.jwt.securiy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name= (:name)")
     Iterable<Product> findByname(@Param("name") String name);

    boolean existsByname(String name);
}
