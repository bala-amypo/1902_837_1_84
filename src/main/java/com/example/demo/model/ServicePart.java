package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_entry_id", nullable = false)
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;
    private BigDecimal cost;
    private Integer quantity;

    public ServicePart() {}

    // GETTERS
    public Long getId() { return id; }
    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public String getPartName() { return partName; }
    public String getPartNumber() { return partNumber; }
    public BigDecimal getCost() { return cost; }
    public Integer getQuantity() { return quantity; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
    public void setPartName(String partName) { this.partName = partName; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
