package com.group05.abstractbusiness.service.Business;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group05.abstractbusiness.model.Business.ProductPhysical;
import com.group05.abstractbusiness.repository.ProdutoFisicoRepository;

@Service
public class ProdutoFisicoService {
    
    @Autowired
    private ProdutoFisicoRepository produtoFisicoRepository;

    public ProductPhysical adicionar(ProductPhysical produto){
        return produtoFisicoRepository.save(produto);
    }

    public Optional<ProductPhysical> buscar(UUID id){
        return produtoFisicoRepository.findById(id);
    }

    public List<ProductPhysical> listar(){
        return produtoFisicoRepository.findAll();
    }

}
