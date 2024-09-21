package com.example.product_service.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Price extends BaseModel{
    private String currency;
    private double amount;
    private double discount;
}