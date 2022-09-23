package com.jpa.dto.one_to_many;

import com.jpa.model.one_to_many.Customer;


public class OrderRequest {

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderRequest() {
    }

    public OrderRequest(Customer customer) {
        this.customer = customer;
    }

    private Customer customer;
}
