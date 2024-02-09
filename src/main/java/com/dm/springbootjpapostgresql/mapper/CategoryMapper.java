package com.dm.springbootjpapostgresql.mapper;

import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.CategoryDto;
import com.dm.springbootjpapostgresql.model.Category;

@Component
public class CategoryMapper {
    
    public CategoryDto mapToDTO(Category category) {
        CategoryDto categoryDTO = new CategoryDto();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    public Category mapToEntity(CategoryDto categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }

}
