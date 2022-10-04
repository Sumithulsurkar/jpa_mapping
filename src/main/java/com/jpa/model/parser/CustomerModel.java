package com.jpa.model.parser;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * To show JSON response we need this Model
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // To exclude null values from JSON
public class CustomerModel {

    private String name;
    private String email;
    private String gender;
    private int nop;

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    private List<ProductModel> products;

    // Getter Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    // Setter Methods

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}
