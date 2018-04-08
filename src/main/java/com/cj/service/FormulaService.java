package com.cj.service;


import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Formula;

import java.util.List;
import java.util.Map;

public interface FormulaService {
    Formula findById(Long id) throws SqlResultCountException;
    List<Formula> findAll();
    List<Formula> findAllByCategory(Long categoryId);
    Map<String, String> findAllIDsAndNames();
    List<Formula> findByName(String name);
}
