package com.group05.abstractbusiness.model.Business;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                                                           // Getters, Setters, HashCode, Equals, ToString
@NoArgsConstructor                                              // Construtor sem argumentos
@AllArgsConstructor                                             // Construtor com todos argumentos
@MappedSuperclass                                               // Super Classe no BD, pode ser herdada em outras classes
@Entity                                                         // Entidade
@Table(name = "product")                                        // Nome da tabela
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)        // Cada classe filha tem sua propria tabela no BD
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                                            // Define a chave primária como Long gerado pelo BD
    
    @Column(name = "nome")                                      // Define o nome da coluna como "nome" no banco de dados
    @NotNull                                                    // Anotação para validar que o campo não pode ser nulo
    private String name;
    
    @Column(name = "marca")                                     // Define o nome da coluna como "marca" no banco de dados
    private String brand;
    
    @Column(name = "categoria")                                 // Define o nome da coluna como "categoria" no banco de dados
    private String category;
    
    @Column(name = "sub_categoria")                             // Define o nome da coluna como "sub_categoria" no banco de dados
    private String subCategory;
    
    @Column(name = "descricao")                                 // Define o nome da coluna como "descricao" no banco de dados
    private String description;
    
    @Column(name = "status")                                    // Define o nome da coluna como "status" no banco de dados
    private boolean status;
    
    @Column(name = "custo")                                     // Define o nome da coluna como "status" no banco de dados
    private double cost;
    
    @Column(name = "preco")                                     // Define o nome da coluna como "preco" no banco de dados                              
    private double price;
    
    @Column(name = "imagem")                                
    private String image;
    
    @Column(name = "criado_em")
    private LocalDateTime createdAt;                                // Define o nome da coluna como "criado_em" no banco de dados
        
    @Column(name = "atualizado_em")                             // Define o nome da coluna como "atualizado_em" no banco de dados
    private LocalDateTime updatedAt;    
        
    @Column(name = "deletado_em")                               // Define o nome da coluna como "deletado_em" no banco de dados
    private LocalDateTime deletedAt;    
    

    @ElementCollection                                                                      // Define o nome da coluna como "tags" no banco de dados e informa que deve ser uma coleção
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "product_id"))         // Define o nome da tabela de coleção como "tags" no banco de dados
    @Column(name = "tag")                                                                   // Define o nome da coluna como "tag" no banco de dados
    @NotEmpty                                                                               // Anotação para validar que a coleção não pode ser vazia ou nula
    private List<String> tags;                                                             

}
