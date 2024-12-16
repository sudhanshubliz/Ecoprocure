package com.esg.ecoprocure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Supplier")
@Data
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
