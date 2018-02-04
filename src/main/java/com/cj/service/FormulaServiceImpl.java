package com.cj.service;

import com.cj.dao.FormulaDao;
import com.cj.model.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormulaServiceImpl implements FormulaService {
    @Autowired private FormulaDao formulaDao;

    @Override
    public Formula findById(Long id) {
        return formulaDao.findById(id);
    }

    @Override
    public List<Formula> findAll() {
        //return  formulaDao.findAll();

        // get all parent formulas
        List<Formula> parentFormulas = formulaDao.findAllParentFormulas();

        //List<Formula> formulas = new ArrayList<>();

        for (Formula formula : parentFormulas) {
            List<Formula> childFormulas = formulaDao.findAllChildFormulas(formula.getId());

            formula.setChildFormulas(childFormulas);

            //formulas.add(formula);
        }

        return parentFormulas;

        //return formulas;
    }

    @Override
    public List<Formula> findAllByCategory(String categoryName) {
        return  formulaDao.findAllByCategory(categoryName);
    }

}
