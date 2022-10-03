package com.jpa.repository.parser;

import com.jpa.model.one_to_many.Customer;
import com.jpa.model.parser.CustomerModel;
import com.jpa.model.parser.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JSONParserRepo extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT c.name, p.pid, p.product_name AS productName, p.price, p.qty FROM jpa.customer c join jpa.product p on c.id = p.cp_fk", nativeQuery = true)
    public List<CustomerResponse> getCustomFields();
}
