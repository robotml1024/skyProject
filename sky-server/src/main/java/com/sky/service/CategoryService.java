package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.entity.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDTO categoryDTO);

    List<Category> listCategory(Integer type);
}
