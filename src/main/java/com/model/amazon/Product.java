package com.model.amazon;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.UUID;
@EntityScan({"com.model.amazon"})
@Entity
@Table(name = "product")
public class Product {
    String name;
    String description;
    Long price;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_generator")
    @SequenceGenerator(name = "product_generator",sequenceName = "product_id_seq",allocationSize = 1)
     Long id;

    public Product(String name, String description, Long price, Long id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }
    public Product(){}
    public Product(String name,String description,Long price){
        this.name=name;
        this.description=description;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
