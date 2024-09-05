package com.api.nexus.service;

import com.api.nexus.entity.Category;
import com.api.nexus.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(int id, Category category) {
        Category catUpdate = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria con id " + id + " no encontrado"));

        catUpdate.setName(category.getName());

        return categoryRepository.save(catUpdate);
    }

    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria con id " + id + " no encontrado"));

        categoryRepository.delete(category);
    }
}
