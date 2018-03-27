package com.cj.service;

import com.cj.dao.FormulaDao;
import com.cj.exceptions.SqlResultCountException;
import com.cj.model.Formula;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FormulaServiceImpl implements FormulaService {
    @Autowired private FormulaDao formulaDao;


    @Override
    public List<Formula> findAll() {
        List<Formula> parentFormulas = formulaDao.findAllParentFormulas();

        for (Formula formula : parentFormulas) {
            List<Formula> childFormulas = formulaDao.findAllChildFormulas(formula.getId());
            formula.setChildFormulas(childFormulas);
        }

        return parentFormulas;
    }

    @Override
    public List<Formula> findAllByCategory(Long categoryId) {
        return  formulaDao.findAllByCategory(categoryId);
    }

    @Override
    public Map<String, String> findAllIDsAndNames() {
        //return formulaDao.findAllParentFormulas();
        return formulaDao.findAllIDsAndNames();
    }

    @Override
    public Formula findById(Long id) throws SqlResultCountException {
        try {
            Formula formula = formulaDao.findById(id);

            List<Formula> childFormulas = formulaDao.findAllChildFormulas(formula.getId());
            Collections.sort(childFormulas);
            formula.setChildFormulas(childFormulas);

            return formula;
        } catch (SqlResultCountException ex) {
            throw ex;
        }

    }
    
}
