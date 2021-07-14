package com.sample.hazelcast.repository;

import com.sample.hazelcast.repository.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p.id from Product p")
    Iterable<Long>findAllId();
}
