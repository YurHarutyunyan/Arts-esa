package com.model.amazon;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/re")
    public RedirectView redirectWithRedirectAttributes(RedirectAttributes attributes) {

        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
        attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
        return new RedirectView("https://www.google.com");
    }
}
