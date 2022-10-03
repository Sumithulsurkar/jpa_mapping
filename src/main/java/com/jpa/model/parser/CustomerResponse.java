package com.jpa.model.parser;

/**
 * When we want to expose custom DB columns to JSON response
 * This way we can increase the performance, as we are not fetching all the columns via fetchAll
 */

public interface CustomerResponse {

    public String getName(); // Name -> belongs to exact db column name
    public int getPid(); // As product is sub set of customer
    public String getProductName();
    public double getPrice();
    public int getQty();

}
