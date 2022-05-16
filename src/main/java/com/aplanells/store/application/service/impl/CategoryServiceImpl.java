package com.aplanells.store.application.service.impl;

import com.aplanells.store.application.dto.CategoryDto;
import com.aplanells.store.application.mapper.CategoryMapper;
import com.aplanells.store.application.service.CategoryService;
import com.aplanells.store.domain.entity.Category;
import com.aplanells.store.domain.persistence.CategoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryPersistence persistence;
    private final CategoryMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryPersistence persistence, CategoryMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.persistence.getAllCategories();
        return this.mapper.toDto(categories);
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Long categoryId) {
        return this.persistence.getCategoryById(categoryId).map(this.mapper::toDto);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = this.persistence.saveCategory(this.mapper.toEntity(categoryDto));
        return this.mapper.toDto(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.persistence.deleteCategory(categoryId);
    }
}
