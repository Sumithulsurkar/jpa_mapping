package com.jpa.service.many_to_many.parser;

import com.jpa.model.one_to_many.Customer;
import com.jpa.model.one_to_many.Product;
import com.jpa.model.parser.CustomerModel;
import com.jpa.model.parser.CustomerResponse;
import com.jpa.model.parser.ProductModel;
import com.jpa.repository.parser.JSONParserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JSONParserService {

    @Autowired
    JSONParserRepo jsonParserRepo;

    /**
     * Custom handling of Columns for JSON response
     * @return
     */
    public List<CustomerModel> getCustProdDataWithCustomCols(){
        List<CustomerModel> customerModel = convertFieldsToModel(jsonParserRepo.getCustomFields());
        return customerModel;
    }

    /**
     * Method to generate the JSON response for GET API
     * @return
     */
    public  List<CustomerModel> getCustProdData(){
        List<CustomerModel> customerModel = new ArrayList<>();
        List<Customer> allCustomers = jsonParserRepo.findAll();

        for(Customer c : allCustomers){
            CustomerModel customerModel1 = new CustomerModel();
            customerModel1.setName(c.getName());
            customerModel1.setEmail(c.getEmail());
            customerModel1.setGender(c.getGender());

            List<ProductModel> productModelList = new ArrayList<>();
            for(Product p : c.getProducts()) {
                ProductModel productModel = new ProductModel();

                productModel.setProductName(p.getProductName());
                productModel.setPid(p.getPid());
                productModel.setPrice(p.getPrice());
                productModel.setQty(p.getQty());
                productModelList.add(productModel);
            }
            customerModel1.setProducts(productModelList);
            customerModel1.setNop(productModelList.size());
            customerModel.add(customerModel1);
        }
        return customerModel;
    }

    /**
     * Method to handle the custom cols in the JSON response
     * @param customerResponses
     * @return
     */
    public List<CustomerModel> convertFieldsToModel(List<CustomerResponse> customerResponses){
        List<CustomerModel> customerModels = new ArrayList<>();
        Map<String, List<CustomerResponse>> collect = customerResponses.stream().collect(Collectors.groupingBy(CustomerResponse::getName));
        collect.forEach((k, v) -> {CustomerModel customerModel1 = new CustomerModel();
            customerModel1.setName(k);
            List<ProductModel> productModelList = new ArrayList<>();

            v.forEach(e -> {
                ProductModel productModel = new ProductModel();
                productModel.setProductName(e.getProductName());
                productModel.setPid(e.getPid());
                productModel.setPrice(e.getPrice());
                productModel.setQty(e.getQty());
                productModelList.add(productModel);
            });
            customerModel1.setProducts(productModelList);
            customerModel1.setNop(productModelList.size());
            customerModels.add(customerModel1);
        });
        return customerModels;
    }
}
