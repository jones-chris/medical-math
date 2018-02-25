package com.cj.service;


import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Formula;

import java.util.List;

public interface FormulaService {
    Formula findById(Long id) throws SqlResultCountException;
    List<Formula> findAll();
    List<Formula> findAllByCategory(String categoryName);
    //Formula findAllChildFormulasJSON(Long id) throws SqlResultCountException;
}
