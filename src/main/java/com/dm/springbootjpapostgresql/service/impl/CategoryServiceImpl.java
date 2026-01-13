package com.dm.springbootjpapostgresql.service.impl;

import com.dm.springbootjpapostgresql.repository.jpa.CategoryRepository;
import com.dm.springbootjpapostgresql.exception.ResourceNotFoundException;
import com.dm.springbootjpapostgresql.mapper.jpa.CategoryMapper;
import com.dm.springbootjpapostgresql.model.entity.Category;
import com.dm.springbootjpapostgresql.dto.CategoryDto;
import com.dm.springbootjpapostgresql.service.CategoryService;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    /* 
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }*/

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        //Category category = categoryMapper.mapToEntity(categoryDto);
        Category category = categoryMapper.toEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        //return categoryMapper.mapToDTO(savedCategory);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        //return categoryMapper.mapToDTO(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        // return categories.stream().map((category) -> categoryMapper.mapToDTO(category))
        //         .collect(Collectors.toList());
        return categories.stream().map((category) -> categoryMapper.toDto(category))
                .collect(Collectors.toList());        
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        // category.setName(categoryDto.getName());
        // category.setDescription(categoryDto.getDescription());
        // category.setId(categoryId);

        categoryMapper.updateCategoryFromDto(categoryDto, category);
        Category updatedCategory = categoryRepository.save(category);

        //return categoryMapper.mapToDTO(updatedCategory);
        return categoryMapper.toDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        categoryRepository.delete(category);
    }
}
