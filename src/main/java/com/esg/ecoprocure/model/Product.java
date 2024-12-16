package com.esg.ecoprocure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Data
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private String name;
}
