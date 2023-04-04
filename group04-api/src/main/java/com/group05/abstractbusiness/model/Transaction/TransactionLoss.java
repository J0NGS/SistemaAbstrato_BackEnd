package com.group05.abstractbusiness.model.Transaction;

import java.util.List;
import java.util.Objects;

import com.group05.abstractbusiness.model.Business.Product;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class TransactionLoss extends Transaction {

    public TransactionLoss(Long value, List<Product> products) {
        super(value);
        this.products = products;
    }

    @ElementCollection
    @NotEmpty
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransactionLoss)) {
            return false;
        }
        TransactionLoss transactionLoss = (TransactionLoss) o;
        return Objects.equals(products, transactionLoss.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            " products='" + getProducts() + "'" +
            "}";
    }
}
