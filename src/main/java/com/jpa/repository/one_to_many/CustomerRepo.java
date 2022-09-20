package com.jpa.repository.one_to_many;

import com.jpa.dto.one_to_many.OrderResponse;
import com.jpa.model.one_to_many.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.jpa.dto.one_to_many.OrderResponse    (c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInfo();
}
