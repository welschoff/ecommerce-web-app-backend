package com.example.ecommerceapp.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/db/cart")
    public List<Product> index() {
        return productRepository.findAll();
    }

    @PostMapping("/db/cart")
    public Product create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String price = body.get("price");
        String image = body.get("image");
        return productRepository.save(new Product(title, price, image));
    }

}
