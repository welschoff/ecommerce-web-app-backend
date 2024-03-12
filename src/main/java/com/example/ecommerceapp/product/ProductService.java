package com.example.ecommerceapp.product;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductService {

    private final RestClient restClient;

    public ProductService() {
        restClient = RestClient.builder()
                .baseUrl("https://fakestoreapi.com")
                .build();
    }

    public List<Product> findAll() {
        return restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
    Product create(Product product) {
        return restClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    void delete() {
        restClient.delete()
                .uri("/products")
                .retrieve()
                .toBodilessEntity();
    }
}
