package org.example.securityproduct.controller;

import org.example.securityproduct.dto.ProductDtoGet;
import org.example.securityproduct.dto.ProductDtoPost;
import org.example.securityproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDtoGet>> getALlProduct (){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoGet> getProductById(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("/admin/post")
    public ResponseEntity<ProductDtoGet> addProduct (@Validated @RequestBody ProductDtoPost productDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productDtoPost));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDtoGet> updateProduct (@PathVariable("id") Long id ,@Validated @RequestBody ProductDtoPost productDtoPost) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(productService.update(id,productDtoPost));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletecandidat (@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        productService.delete(id);
        return ResponseEntity.ok("Product with id :"+id+" is delete");
    }

}
