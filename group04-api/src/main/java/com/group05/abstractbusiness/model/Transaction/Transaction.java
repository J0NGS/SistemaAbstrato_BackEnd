package com.group05.abstractbusiness.model.Transaction;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")                 // Padrão da data
    private LocalDateTime transactionDate;

    private Long value;

    private int discount;


    public Transaction(Long value) {
        onCreate();
        this.value = value;
        this.discount = 0;
    }

    public Transaction(Long value, int discount) {
        onCreate();
        this.value = value;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Transaction(id=" + id + ", transactionDate=" + transactionDate + ", value=" + value + ", discount="
                + discount + ")";
    }

    @PrePersist                                            // Anotação para que o metodo seja executado antes da prescrição no BD, para salvar a registerDate sempre com o horario atual
    protected void onCreate() {
        this.transactionDate = LocalDateTime.now();
    }

}
