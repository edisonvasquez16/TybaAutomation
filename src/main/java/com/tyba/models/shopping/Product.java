package com.tyba.models.shopping;

import lombok.Data;

@Data
public class Product {

    private String name;
    private String color;
    private String amount;
    private int quantity;
    private String totalAmountForItem;

}
