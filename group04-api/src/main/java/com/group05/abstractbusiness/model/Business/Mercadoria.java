// package com.group05.abstractbusiness.model.Business;

// import java.util.UUID;

// import jakarta.persistence.Column;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.MappedSuperclass;
// import lombok.Getter;
// import lombok.Setter;

// @MappedSuperclass
// @Getter
// @Setter
// public abstract class Mercadoria {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     @Column(name = "id", unique = true)
//     private UUID ID;
    
//     @Column(name = "nome")
//     private String nome;
    
//     @Column(name = "descricao")
//     private String descricao;
    
//     @Column(name = "status")
//     private Boolean status;
    
//     @Column(name = "custo")
//     private Double custo;
    
//     @Column(name = "preco")
//     private Double preco;

//     public Mercadoria() {}

//     public Mercadoria(UUID iD, String nome, String descricao, Boolean status, Double custo, Double preco) {
//         ID = iD;
//         this.nome = nome;
//         this.descricao = descricao;
//         this.status = status;
//         this.custo = custo;
//         this.preco = preco;
//     }
// }
