package com.group05.abstractbusiness.service.Business;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ProductIntelectual;
import com.group05.abstractbusiness.repository.ProdutoIntelectualRepository;

@Service
public class ProdutoIntelectualService {
    
    @Autowired
    private ProdutoIntelectualRepository produtoIntelectualRepository;

    public ProductIntelectual adicionar(ProductIntelectual produto){
        return produtoIntelectualRepository.save(produto);
    }

    public Optional<ProductIntelectual> buscar(UUID id){
        return produtoIntelectualRepository.findById(id);
    }

    public List<ProductIntelectual> listar(){
        return produtoIntelectualRepository.findAll();
    }
}
