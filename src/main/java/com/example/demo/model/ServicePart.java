package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;
    private Integer quantity;

    public ServicePart() {}

    public Long getId() {
        return id;
    }

    public String getPartName() {
        return partName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
