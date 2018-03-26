package com.cj.dao;


import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Formula;

import java.util.List;
import java.util.Map;

public interface FormulaDao {
    Formula findById(Long id) throws SqlResultCountException;
    //List<Formula> findAll();
    List<Formula> findAllByCategory(Long categoryId);
    //Formula findChildFormula(Long parentId, String childFormulaName);
    List<Formula> findAllChildFormulas(Long id);
    List<Formula> findAllParentFormulas();
    Map<String, String> findAllIDsAndNames();
}
