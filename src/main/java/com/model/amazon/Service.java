package com.model.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@org.springframework.stereotype.Service
public class Service {

    private final ProductRepository productRepository;

    public Service(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> get() {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    public Stream<Product> getById(Long id) {
        List<Product> products = get();
       return  products.stream().filter(t->(t.getId().equals(id)));

    }

}

