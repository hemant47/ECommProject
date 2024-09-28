package com.example.product_service.service;

import com.example.product_service.dto.ProductResponseDTO;
import com.example.product_service.exception.InvalidTitleException;
import com.example.product_service.exception.ProductNotFoundException;
import com.example.product_service.model.Category;
import com.example.product_service.model.Price;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;


import java.util.Scanner;
import java.util.UUID;

public class ProductServiceImplTest {

    @Mock // we need a mock object of the given attribute
    private ProductRepository productRepository;
    @InjectMocks // this is the class we want to test, and this is where we would inject the mock objects
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup(){
        System.out.println("HelloWorld, from BeforeEach");
        MockitoAnnotations.openMocks(this); // creates auto closeable resources for each test method
    }

    @Test
    public void testFindProductByTitleSuccess() throws ProductNotFoundException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = "testProductTitle";
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);
        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);
        //Act
        ProductResponseDTO actualResponse = productService.findProductByTitle(testTitle);
        //Assert
        Assertions.assertEquals(actualResponse.getTitle(), mockProduct.getTitle());
        Assertions.assertEquals(actualResponse.getDescription(), mockProduct.getDescription());
        Assertions.assertEquals(actualResponse.getId(), mockProduct.getId());
        Assertions.assertEquals(actualResponse.getPrice(), mockProduct.getPrice().getAmount());
    }

    @Test
    public void testFindByProductByTitle_RepoRespondsWithNullObject() throws ProductNotFoundException {
        //Arrange
        String testTitle = "testProductTitle";
        when(productRepository.findByTitle(testTitle)).thenReturn(null);
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.findProductByTitle(testTitle));
    }

    @Test
    public void testFindProductByTitle_NullTitle() throws ProductNotFoundException {
        //Arrange
        Price mockPrice = new Price();
        mockPrice.setAmount(100);

        Category mockCategory = new Category();
        mockCategory.setCategoryName("mockCategory");

        String testTitle = null;
        Product mockProduct = new Product();
        mockProduct.setId(UUID.randomUUID());
        mockProduct.setTitle(testTitle);
        mockProduct.setDescription("testDescription");
        mockProduct.setPrice(mockPrice);
        mockProduct.setCategory(mockCategory);
        when(productRepository.findByTitle(testTitle)).thenReturn(mockProduct);
        //Assert and Act
        Assertions.assertThrows(InvalidTitleException.class, () -> productService.findProductByTitle(testTitle) );
    }




}