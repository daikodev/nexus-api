package com.api.nexus.service;

import com.api.nexus.entity.Product;
import com.api.nexus.pagination.PageableQuery;
import com.api.nexus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getProductsByPage(PageableQuery pageableQuery) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageableQuery.getInOrder()),
                pageableQuery.getOrderBy());

        Pageable pageable = PageRequest.of(pageableQuery.getPage(),
                pageableQuery.getItemsByPage(), sort);

        return productRepository.findAll(pageable);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product prodUpdate = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto con id " + id + " no encontrado"));

        prodUpdate.setName(product.getName());
        prodUpdate.setDescription(product.getDescription());
        prodUpdate.setStock(product.getStock());
        prodUpdate.setPrice(product.getPrice());
        prodUpdate.setCategory(product.getCategory());

        return productRepository.save(prodUpdate);
    }

    public void deleteProduct(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto con id " + id + " no encontrado"));

        productRepository.delete(product);
    }
}
