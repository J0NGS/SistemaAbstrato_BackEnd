package com.group05.abstractbusiness.model.Business;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@Entity
@MappedSuperclass
public abstract class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String status;

    private double costBudget;

    private double hourPrice;

    private int durationService;

    private double finalPrice;

    public Service() {
        // default constructor
    }

    public Service(String name, String description, String status, double costBudget, double hourPrice,
                   int durationService, double finalPrice) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.costBudget = costBudget;
        this.hourPrice = hourPrice;
        this.durationService = durationService;
        this.finalPrice = finalPrice;
    }

}
