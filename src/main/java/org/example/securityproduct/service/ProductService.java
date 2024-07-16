package org.example.securityproduct.service;

import org.example.securityproduct.dto.ProductDtoGet;
import org.example.securityproduct.dto.ProductDtoPost;
import org.example.securityproduct.entity.Product;
import org.example.securityproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements BaseService<ProductDtoPost, ProductDtoGet> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDtoGet create(ProductDtoPost productDtoPost) {
        Product product = Product.builder()
                .name(productDtoPost.getName())
                .price(productDtoPost.getPrice())
                .build();
        productRepository.save(product);
        return productToProductDtoGet(product);
    }

    @Override
    public ProductDtoGet update(Long id, ProductDtoPost productDtoPost) throws ChangeSetPersister.NotFoundException {
        Product product = getById(id);
        product.setName(productDtoPost.getName());
        product.setPrice(productDtoPost.getPrice());
        productRepository.save(product);
        return productToProductDtoGet(product);
    }

    @Override
    public boolean delete(Long id) throws ChangeSetPersister.NotFoundException {
        Product product = getById(id);
        productRepository.delete(product);
        return true;
    }

    @Override
    public ProductDtoGet findById(Long id) throws ChangeSetPersister.NotFoundException {
        return productToProductDtoGet(getById(id));
    }

    @Override
    public List<ProductDtoGet> findAll() {
        return productListToproductDtoList((List<Product>) productRepository.findAll());
    }
    private Product getById (Long id) throws ChangeSetPersister.NotFoundException {
        return productRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
    private ProductDtoGet productToProductDtoGet (Product product){
        return ProductDtoGet.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    private List<ProductDtoGet> productListToproductDtoList(List<Product> productList){
        return productList.stream().map(this:: productToProductDtoGet).collect(Collectors.toList());
    }
}
