package com.group05.abstractbusiness.model.Business;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "intelectualPd_tb")
public class ProductIntelectual extends ProductDecorator {
    
    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "pages")
    private int pages;

    @Column(name = "edition")
    private int edition;

    public ProductIntelectual(Product product, String author, String publisher, String isbn, int pages, int edition) {
        super(product);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
        this.edition = edition;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductIntelectual)) {
            return false;
        }
        ProductIntelectual productIntelectual = (ProductIntelectual) o;
        return Objects.equals(author, productIntelectual.author) && Objects.equals(publisher, productIntelectual.publisher) && Objects.equals(isbn, productIntelectual.isbn) && pages == productIntelectual.pages && edition == productIntelectual.edition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, publisher, isbn, pages, edition);
    }


}
