package com.dm.springbootjpapostgresql.mapper.jpa;

import org.springframework.stereotype.Component;

import com.dm.springbootjpapostgresql.dto.CategoryDto;
import com.dm.springbootjpapostgresql.model.entity.Category;

import org.mapstruct.BeanMapping;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

// @Component
// public class CategoryMapper {
    
//     public CategoryDto mapToDTO(Category category) {
//         CategoryDto categoryDTO = new CategoryDto();
//         categoryDTO.setId(category.getId());
//         categoryDTO.setName(category.getName());
//         categoryDTO.setDescription(category.getDescription());
//         return categoryDTO;
//     }

//     public Category mapToEntity(CategoryDto categoryDTO) {
//         Category category = new Category();
//         category.setId(categoryDTO.getId());
//         category.setName(categoryDTO.getName());
//         category.setDescription(categoryDTO.getDescription());
//         return category;
//     }

// }

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "posts", ignore = true)
    Category toEntity(CategoryDto categoryDto);

    // This updates the existing Category entity with data from CategoryDTO
    @Mapping(target = "id", ignore = true) // Usually, we don't want to change the ID
    @Mapping(target = "posts", ignore = true)   
    // This tells MapStruct: if a DTO field is null, don't touch the Entity field
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) 
    void updateCategoryFromDto(CategoryDto dto, @MappingTarget Category entity);   

    // This custom condition applies to ALL String mappings in this mapper
    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }    

    CategoryDto toDto(Category category);

}
