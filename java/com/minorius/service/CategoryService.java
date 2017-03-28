package com.minorius.service;

import com.minorius.entity.Category;
import com.minorius.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category category){
        categoryRepository.addCategory(category);
    }

    public Category getCategoryById(long id){
        return categoryRepository.getCategoryById(id);
    }

    public ArrayList<Category> getAllCategory(){

        return categoryRepository.getAllCategory();
    }
}
