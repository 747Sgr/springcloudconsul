package com.sunwoda.productservice.entity;

/**
 * Description:
 *
 * @author shiguorang
 * @date 2021-04-06 16:44:53
 */
public class ProductModel {

    private String id;
    private String productName;
    private Double price;

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
