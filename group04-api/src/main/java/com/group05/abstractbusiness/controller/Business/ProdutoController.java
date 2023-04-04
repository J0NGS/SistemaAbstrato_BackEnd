package com.group05.abstractbusiness.controller.Business;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.group05.abstractbusiness.model.Business.ProductPhysical;
import com.group05.abstractbusiness.service.Business.ProdutoDigitalService;
import com.group05.abstractbusiness.service.Business.ProdutoFisicoService;
import com.group05.abstractbusiness.service.Business.ProdutoIntelectualService;


/**
 *  ----------- AJEITAR ----------- 
 *  REFATORAR ESSE CONTROLLER PARA IMPLEMENTAR O PADRÃO DE PROJETO ABSTRACT FACTORY
 */
@RestController
@RequestMapping("/api")
public class ProdutoController {
    
    @Autowired
    private ProdutoFisicoService produtoFisicoService;

    // @Autowired
    // private ProdutoDigitalService produtoDigitalService;

    // @Autowired
    // private ProdutoIntelectualService produtoIntelectualService;

    // @Autowired
    // private ServicoFisicoService serviceFisicoService;

    // @Autowired
    // private ServicoDigitalService servicoDigitalService;

    // @Autowired
    // private ServicoIntelectualService servicoIntelectualService;

    //#region CRIAR PRODUTOS OU SERVIÇOS

    @PostMapping("/produto/fisico")
    public ResponseEntity<ProductPhysical> criarProduto(@RequestBody ProductPhysical produtoFisico){
        try {
            return new ResponseEntity<>(produtoFisicoService.adicionar(produtoFisico),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    //#endregion

}
