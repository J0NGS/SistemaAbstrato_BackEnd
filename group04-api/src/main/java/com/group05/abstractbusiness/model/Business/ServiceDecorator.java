package com.group05.abstractbusiness.model.Business;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_decorator")
public class ServiceDecorator {

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public ServiceDecorator() {
        // default constructor
    }

    public ServiceDecorator(Service service) {
        this.service = service;
    }
}
