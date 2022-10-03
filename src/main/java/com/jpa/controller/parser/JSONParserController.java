package com.jpa.controller.parser;

import com.jpa.model.parser.CustomerModel;
import com.jpa.service.many_to_many.parser.JSONParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JSONParserController {

    @Autowired
    JSONParserService jsonParserService;


    /**
     * http://localhost:8080/getCustomerProducts
     * @return
     */
    @GetMapping("/getCustomerProducts")
    public List<CustomerModel> getCustomerProductsData(){
         return jsonParserService.getCustProdData();
    }

    /**
     * http://localhost:8080/getCustomerProductsDataWithCustCols
     * @return
     */

    @GetMapping("/getCustomerProductsDataWithCustCols")
    public List<CustomerModel> getCustomerProductsDataWithCustCols(){
        return jsonParserService.getCustProdDataWithCustomCols();
    }
}
