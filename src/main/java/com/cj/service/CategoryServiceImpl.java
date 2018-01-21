package com.cj.service;


import com.cj.dao.CategoryDao;
import com.cj.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired private CategoryDao categoryDao;

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
