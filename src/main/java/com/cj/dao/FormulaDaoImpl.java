package com.cj.dao;


import com.cj.mappers.FormulaRowMapper;
import com.cj.model.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FormulaDaoImpl implements FormulaDao {

    @Autowired DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public Formula findById(Long id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.id AS formula_id, ");
        sql.append(       "f.name AS formula_name, ");
        sql.append(       "f.parameters AS formula_parameters, ");
        sql.append(       "c.id AS category_id, ");
        sql.append(       "c.name AS category_name ");
        sql.append("FROM medical_math.formula f, ");
        sql.append(     "medical_math.category c, ");
        sql.append(     "medical_math.formula_category fc ");
        sql.append(String.format("WHERE f.id = %s", id));
        sql.append("  AND f.id = fc.formula_id ");
        sql.append("  AND c.id = fc.category_id;");

        //String sql = String.format("SELECT * FROM medical_math.formula WHERE id = %s;", id);

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        // Query should only return one record, but jdbcTemplate's query method returns a list,
        // so get the first element in list and return it.
        return jdbcTemplate.query(sql.toString(), new FormulaRowMapper()).get(0);
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
