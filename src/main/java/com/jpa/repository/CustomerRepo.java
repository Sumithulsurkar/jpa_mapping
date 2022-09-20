package com.jpa.repository;

import com.jpa.dto.OrderResponse;
import com.jpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.jpa.dto.OrderResponse    (c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInfo();
}
