package com.cj.dao;


import com.cj.model.Formula;

import java.util.List;

public interface FormulaDao {
    Formula findById(Long id);
    List<Formula> findAll();
    List<Formula> findAllByCategory();
    boolean add(Formula formula);
    boolean update(Formula formula);
    boolean delete(Long id);
    boolean addFavorite(Long id);
    boolean deleteFavorite(Long id);
}
