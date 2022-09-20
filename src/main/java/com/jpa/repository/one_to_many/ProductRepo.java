package com.jpa.repository.one_to_many;

import com.jpa.model.one_to_many.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
