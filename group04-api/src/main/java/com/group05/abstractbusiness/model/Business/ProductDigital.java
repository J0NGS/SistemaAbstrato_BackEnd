package com.group05.abstractbusiness.model.Business;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "product_digital")
public class ProductDigital extends ProductDecorator {



    public ProductDigital(Product product,String fileUrl, String fileType,
    Double fileSize, int downloadCount, LocalDateTime expiryDate) {
    super(product);
    this.fileUrl = fileUrl;
    this.fileType = fileType;
    this.fileSize = fileSize;
    this.downloadCount = downloadCount;
    this.expiryDate = expiryDate;
}


    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private Double fileSize;

    @Column(name = "download_count")
    private Integer downloadCount;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductDigital)) {
            return false;
        }
        ProductDigital productDigital = (ProductDigital) o;
        return Objects.equals(fileUrl, productDigital.fileUrl) && Objects.equals(fileType, productDigital.fileType) && Objects.equals(fileSize, productDigital.fileSize) && Objects.equals(downloadCount, productDigital.downloadCount) && Objects.equals(expiryDate, productDigital.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileUrl, fileType, fileSize, downloadCount, expiryDate);
    }

}
