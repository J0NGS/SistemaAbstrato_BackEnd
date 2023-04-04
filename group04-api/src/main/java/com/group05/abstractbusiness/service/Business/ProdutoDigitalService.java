package com.group05.abstractbusiness.service.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ProductDigital;
import com.group05.abstractbusiness.repository.ProdutoDigitalRepository;

@Service
public class ProdutoDigitalService {
    
    @Autowired
    private ProdutoDigitalRepository produtoDigitalRepository;

    public ProductDigital adicionar(ProductDigital produto){
        return produtoDigitalRepository.save(produto);
    }

    public Optional<ProductDigital> buscar(UUID id){
        return produtoDigitalRepository.findById(id);
    }

    public List<ProductDigital> listar(){
        return produtoDigitalRepository.findAll();
    }

}
