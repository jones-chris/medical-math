package com.cj.service;

import com.cj.dao.FormulaDao;
import com.cj.model.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulaServiceImpl implements FormulaService {
    @Autowired FormulaDao formulaDao;

    @Override
    public Formula findById(Long id) {
        return formulaDao.findById(id);
    }

    @Override
    public List<Formula> findAll() {
        return null;
    }

    @Override
    public List<Formula> findAllByCategory() {
        return null;
    }

    @Override
    public boolean add(Formula formula) {
        return false;
    }

    @Override
    public boolean update(Formula formula) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean addFavorite(Long id) {
        return false;
    }

    @Override
    public boolean deleteFavorite(Long id) {
        return false;
    }
}
