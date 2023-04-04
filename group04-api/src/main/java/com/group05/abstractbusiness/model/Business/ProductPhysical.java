package com.group05.abstractbusiness.model.Business;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "product_physical")
public class ProductPhysical extends ProductDecorator {

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "width")
    private Float width;

    @Column(name = "image_url")
    private String imageUrl;

    public ProductPhysical(Product product, Float weight, Float height, Float width, String imageUrl) {
        super(product);
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.imageUrl = imageUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductPhysical)) {
            return false;
        }
        ProductPhysical productPhysical = (ProductPhysical) o;
        return Objects.equals(weight, productPhysical.weight) && Objects.equals(height, productPhysical.height) && Objects.equals(width, productPhysical.width) && Objects.equals(imageUrl, productPhysical.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height, width, imageUrl);
    }

}