package com.springapp.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList = new ArrayList<Product>();

    public void addItem(Product product) {
        this.productList.add(product);
    }

    public String getItemName() {
        StringBuilder productName = new StringBuilder();
        for(Product product : productList){
            if(productName.length() != 0){
                productName.append(" && ");
            }
            productName.append(product.getName());
        }
        return productName.toString();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
