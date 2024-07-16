package org.example.securityproduct.repository;

import org.example.securityproduct.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
