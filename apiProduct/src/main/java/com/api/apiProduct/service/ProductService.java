package com.api.apiProduct.service;

import com.api.apiProduct.model.Product;
import com.api.apiProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // criar
    public Product save(Product product){
        validate(product);
        return productRepository.save(product);
    }
    // listar tudo
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    // listar por id - teste 1
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
//    Optional<T> findById(ID id);

    public boolean existsById(Long id){
        return productRepository.existsById(id);
    }
//    boolean existsById(ID id);



    // editar
    public Product update(Long id, Product updateProduct){
        Product product = productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Task not found"));
        product.setTitle(updateProduct.getTitle());
        product.setCategory(updateProduct.getCategory());
        product.setDescription(updateProduct.getDescription());
        product.setStatus(updateProduct.getStatus());
        return productRepository.save(product);
    }
    // delete
    public String delete(Long id){
        productRepository.deleteById(id);
        return "Task deleted";
    }

    private void validate(Product product){
        if (product.getTitle() == null)  {
            throw new IllegalArgumentException("The name of title can´t be null");
        }
    }
}
