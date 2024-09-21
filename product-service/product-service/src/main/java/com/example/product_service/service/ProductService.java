package com.example.product_service.service;

import com.example.product_service.dto.ProductListResponseDTO;
import com.example.product_service.dto.ProductRequestDTO;
import com.example.product_service.dto.ProductResponseDTO;
import com.example.product_service.exception.ProductNotFoundException;
import com.example.product_service.model.Product;

import java.util.List;

public interface ProductService {
    ProductListResponseDTO getAllProducts() throws Exception;

    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
    ProductResponseDTO findProductByTitle(String title) throws ProductNotFoundException;
}