package com.jpa.controller;

import com.jpa.dto.OrderRequest;
import com.jpa.dto.OrderResponse;
import com.jpa.model.Customer;
import com.jpa.repository.CustomerRepo;
import com.jpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    /**
     * refer request.JSON
     * @param orderRequest
     * @return
     */
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerRepo.save(orderRequest.getCustomer());
    }

    /**
     * http://localhost:8080/findAllOrders
     * @return
     */
    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepo.findAll();
    }

    /**
     * http://localhost:8080/getInfo
     * @return
     */
    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepo.getJoinInfo();
    }
}
