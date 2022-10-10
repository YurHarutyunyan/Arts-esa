package com.model.amazon;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

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
@PostMapping(value = "/getbyid/{id}")
    public Stream<Product> getById(@PathVariable  Long id){
    return service.getById(id);
}
    @RequestMapping(name = "/trying")

    @PostMapping("/RestEndpoint")
    public String sampleEndpoint(@RequestHeader Map<String, String> headers, @RequestBody Map<String,String> body) {
     return   headers.toString() ;

    }
    @PostMapping()
    public ResponseEntity<Map<String,String>> getHeader(@RequestHeader(value = "Accept")String acceptHeader,
                            @RequestHeader(value = "Authorization") String authorizationHeader
    ){
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept",acceptHeader);
    headers.put("Authorization",authorizationHeader);
    return ResponseEntity.status(HttpStatus.OK).body(headers);
    }

}
