package com.group05.abstractbusiness.API.controller.Stock;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.modules.model.Business.ProdutoDigital;
import com.group05.abstractbusiness.modules.model.Business.ProdutoFisico;
import com.group05.abstractbusiness.modules.model.Business.ProdutoIntelectual;
import com.group05.abstractbusiness.modules.model.Stock.StockDigital;
import com.group05.abstractbusiness.modules.model.Stock.StockFisico;
import com.group05.abstractbusiness.modules.model.Stock.StockIntelectual;
import com.group05.abstractbusiness.modules.model.Stock.StockProducts;
import com.group05.abstractbusiness.modules.service.Stock.StockDigitalService;
import com.group05.abstractbusiness.modules.service.Stock.StockFisicoService;
import com.group05.abstractbusiness.modules.service.Stock.StockIntelectualService;
import com.group05.abstractbusiness.modules.service.Business.ProdutoDigitalService;
import com.group05.abstractbusiness.modules.service.Business.ProdutoFisicoService;
import com.group05.abstractbusiness.modules.service.Business.ProdutoIntelectualService;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockFisicoService stockFisicoService;

    @Autowired
    private StockDigitalService stockDigitalService;

    @Autowired
    private StockIntelectualService stockIntelectualService;

    @Autowired
    private ProdutoFisicoService produtoFisicoService;

    @Autowired
    private ProdutoDigitalService produtoDigitalService;

    @Autowired
    private ProdutoIntelectualService produtoIntelectualService;

    @PostMapping("/adicionar/{tipo}")
    public StockProducts adicionar(@PathVariable String tipo, @RequestBody StockProducts stockProducts){
        if(tipo.equals("fisico")){
            return this.stockFisicoService.adicionar((StockFisico) stockProducts);
        } else if(tipo.equals("digital")){
            return this.stockDigitalService.adicionar((StockDigital) stockProducts);
        } else if(tipo.equals("intelectual")){
            return this.stockIntelectualService.adicionar((StockIntelectual) stockProducts);
        } else {
            return null;
        }
    }

    @PostMapping("/fisico/{idstock}/{idproduto}")
    public StockFisico adicionarProdutoFisico(@PathVariable UUID idstock, @PathVariable UUID idproduto){
        Optional<StockFisico> stock = this.stockFisicoService.buscar(idstock);
        Optional<ProdutoFisico> proOptional = this.produtoFisicoService.buscar(idproduto);
        stock.get().getProdutosFisicos().add(proOptional.get());
        stock.get().setQuantidade(stock.get().getQuantidade()+1);
        proOptional.get().setStock(stock.get());
        return this.stockFisicoService.adicionar(stock.get());
    }

    @PostMapping("/digital/{idstock}/{idproduto}")
    public StockDigital adicionarProdutoDigital(@PathVariable UUID idstock, @PathVariable UUID idproduto){
        Optional<StockDigital> stock = this.stockDigitalService.buscar(idstock);
        Optional<ProdutoDigital> proOptional = this.produtoDigitalService.buscar(idproduto);
        stock.get().getProdutosDigitais().add(proOptional.get());
        stock.get().setQuantidade(stock.get().getQuantidade()+1);
        proOptional.get().setStock(stock.get());
        return this.stockDigitalService.adicionar(stock.get());
    }

    @PostMapping("/intelectual/{idstock}/{idproduto}")
    public StockIntelectual adicionarProdutoIntelectual(@PathVariable UUID idstock, @PathVariable UUID idproduto){
        Optional<StockIntelectual> stock = this.stockIntelectualService.buscar(idstock);
        Optional<ProdutoIntelectual> proOptional = this.produtoIntelectualService.buscar(idproduto);
        stock.get().getProdutosIntelectuais().add(proOptional.get());
        stock.get().setQuantidade(stock.get().getQuantidade()+1);
        proOptional.get().setStock(stock.get());
        return this.stockIntelectualService.adicionar(stock.get());
    }

    @GetMapping("/fisico/listar")
    public List<StockFisico> listarFisicos(){
        return this.stockFisicoService.listar();
    }

    @GetMapping("/digital/listar")
    public List<StockDigital> listarDigitais(){
        return this.stockDigitalService.listar();
    }

    @GetMapping("/intelectual/listar")
    public List<StockIntelectual> listarIntelectuais(){
        return this.stockIntelectualService.listar();
    }

    @DeleteMapping("/{tipo}/{uuid}")
    public String deletarStock(@PathVariable String tipo, @PathVariable UUID uuid){
        if(tipo.equals("fisico")){
            return this.stockFisicoService.deletar(uuid);
        } else if(tipo.equals("digital")){
            return this.stockDigitalService.deletar(uuid);
        } else if(tipo.equals("intelectual")){
            return this.stockIntelectualService.deletar(uuid);
        }
        return "Nenhum estoque achado!!!";
    }

}