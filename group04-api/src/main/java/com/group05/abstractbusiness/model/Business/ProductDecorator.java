package com.group05.abstractbusiness.model.Business;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ProductDecorator extends Product {
    @NotNull(message = "The decorated product cannot be null")
    private Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    public ProductDecorator() {
    }

    public Product getDecoratedProduct() {
        return decoratedProduct;
    }

    public void setDecoratedProduct(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public void setName(String name) {
        decoratedProduct.setName(name);
    }

    @Override
    public String getDescription() {
        return decoratedProduct.getDescription();
    }

    @Override
    public void setDescription(String description) {
        decoratedProduct.setDescription(description);
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice();
    }

    @Override
    public void setPrice(double price) {
        decoratedProduct.setPrice(price);
    }

    public String getImageUrl() {
        return decoratedProduct.getImage();
    }

    
    public void setImageUrl(String imageUrl) {
        decoratedProduct.setImage(imageUrl);
    }

    public LocalDateTime getCreatedDate(){
        return decoratedProduct.getCreatedAt();
    } 

    public LocalDateTime getUpdateDate(){
        return decoratedProduct.getUpdatedAt();
    } 

    public LocalDateTime getDeletedDate(){
        return decoratedProduct.getDeletedAt();
    } 

    @Override
    public String toString() {
        return decoratedProduct.toString();
    }
}
