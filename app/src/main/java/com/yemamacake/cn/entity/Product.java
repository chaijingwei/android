package com.yemamacake.cn.entity;

import java.math.BigDecimal;

public class Product {
    private Integer imageUrlId;
    private String productName;
    private BigDecimal productPrice;

    private String productIntroduce;


    public Product() {
    }

    public Integer getImageUrlId() {
        return imageUrlId;
    }

    public void setImageUrlId(Integer imageUrlId) {
        this.imageUrlId = imageUrlId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductIntroduce() {
        return productIntroduce;
    }

    public void setProductIntroduce(String productIntroduce) {
        this.productIntroduce = productIntroduce;
    }
}
