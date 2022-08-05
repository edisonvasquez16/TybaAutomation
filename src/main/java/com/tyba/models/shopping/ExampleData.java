package com.tyba.models.shopping;

import lombok.Data;

import java.util.List;

@Data
public class ExampleData {

    private int id;
    private String totalItems;
    private String totalAmount;
    private String subTotal;
    private String shipping;
    private String totalWithTaxes;
    private List<Product> products;

}
