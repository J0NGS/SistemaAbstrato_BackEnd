package com.group05.abstractbusiness.model.Transaction;

import java.util.Objects;

import com.group05.abstractbusiness.model.Person.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class TransactionOut extends Transaction {

    public TransactionOut(Customer customer,Long value,int discount, String document) {
        super(value, discount);
        this.customer = customer;
        this.document = document;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @Column(unique = false)
    @NotEmpty
    private Customer customer;

    @Column(name = "DocumentPath")
    @NotEmpty
    private String document;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransactionOut)) {
            return false;
        }
        TransactionOut transactionOut = (TransactionOut) o;
        return Objects.equals(customer, transactionOut.customer) && Objects.equals(document, transactionOut.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, document);
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            " customer='" + customer.getName() + "'" +
            ", document='" + getDocument() + "'" +
            "}";
    }
}