package com.group05.abstractbusiness.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.model.Business.ProductPhysical;

public interface ProdutoFisicoRepository extends JpaRepository<ProductPhysical, UUID> {

}
