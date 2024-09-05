package com.api.nexus.repository;

import com.api.nexus.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
