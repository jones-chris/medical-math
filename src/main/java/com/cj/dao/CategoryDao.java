package com.cj.dao;


import com.cj.model.Category;

import java.util.List;

public interface CategoryDao {
    Category findById(Long id);
    List<Category> findAll();
}
