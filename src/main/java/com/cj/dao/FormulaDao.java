package com.cj.dao;


import com.cj.model.Formula;

import java.util.List;

public interface FormulaDao {
    Formula findById(Long id);
    List<Formula> findAll();
    List<Formula> findAllByCategory(String categoryName);
    Formula findChildFormula(Long parentId, String childFormulaName);
    List<Formula> findAllChildFormulas(Long id);
    List<Formula> findAllParentFormulas();
}
