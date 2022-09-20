package com.jpa.controller.one_to_many;

import com.jpa.dto.one_to_many.OrderRequest;
import com.jpa.dto.one_to_many.OrderResponse;
import com.jpa.model.one_to_many.Customer;
import com.jpa.repository.one_to_many.CustomerRepo;
import com.jpa.repository.one_to_many.ProductRepo;
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
