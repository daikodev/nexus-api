package com.api.nexus.controller;

import com.api.nexus.entity.Product;
import com.api.nexus.pagination.PageableQuery;
import com.api.nexus.pagination.ProductPageableQuery;
import com.api.nexus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nexus/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public Page<Product> getProductsByPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer itemsByPage,
            @RequestParam(defaultValue = "name") String orderBy,
            @RequestParam(defaultValue = "DESC") String inOrder) {

        ProductPageableQuery pageableQuery = new ProductPageableQuery();
        pageableQuery.setPage(page);
        pageableQuery.setItemsByPage(itemsByPage);
        pageableQuery.setOrderBy(orderBy);
        pageableQuery.setInOrder(inOrder);

        return productService.getProductsByPage(pageableQuery);
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }


}

