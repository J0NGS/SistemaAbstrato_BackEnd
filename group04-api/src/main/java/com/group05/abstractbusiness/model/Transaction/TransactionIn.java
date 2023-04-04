package com.group05.abstractbusiness.model.Transaction;

import java.util.Objects;

import com.group05.abstractbusiness.model.Person.Supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class TransactionIn extends Transaction{

    public TransactionIn(Long value, Supplier supplier, String document) {
        super(value);
        this.supplier = supplier;
        this.document = document;
    }
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @Column(unique = false)
    @NotEmpty
    private Supplier supplier;
    
    @Column(name = "DocumentPath")
    @NotEmpty
    private String document;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransactionIn)) {
            return false;
        }
        TransactionIn transactionIn = (TransactionIn) o;
        return Objects.equals(supplier, transactionIn.supplier) && Objects.equals(document, transactionIn.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplier, document);
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
            " supplier='" + getSupplier() + "'" +
            ", document='" + getDocument() + "'" +
            "}";
    }


}
