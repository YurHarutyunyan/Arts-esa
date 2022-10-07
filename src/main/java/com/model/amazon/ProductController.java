package com.model.amazon;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/amazon")
public class ProductController {
   private Service service;
public ProductController(Service service){
    this.service=service;
}
@RequestMapping(value = "/get")
    public List<Product> getList(){
       List<Product> products= service.get();
        return products;
}
@PostMapping(value = "/save")
    public Product saveProduct(@RequestBody Product product){
    service.save(product);
        return product;
}
@PostMapping(value = "/id")
    public Optional<Product> getById(@PathVariable  Long id){
    return service.getById(id);
}
}
