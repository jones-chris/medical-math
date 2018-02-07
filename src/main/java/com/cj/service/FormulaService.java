package com.cj.service;


import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Formula;

import java.util.List;

public interface FormulaService {
    Formula findById(Long id);
    List<Formula> findAll();
    List<Formula> findAllByCategory(String categoryName);
    Formula findAllChildFormulasJSON(String name, Long id) throws SqlResultCountException;
}
