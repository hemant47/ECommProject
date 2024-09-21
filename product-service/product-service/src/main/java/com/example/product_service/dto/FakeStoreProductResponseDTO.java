package com.example.product_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private String id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}