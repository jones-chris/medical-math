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

    @Autowired private DataSource dataSource;
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

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        // Query should only return one record, but jdbcTemplate's query method returns a list,
        // so get the first element in list and return it.
        return jdbcTemplate.query(sql.toString(), new FormulaRowMapper()).get(0);
    }

    @Override
    public List<Formula> findAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.id AS formula_id, ");
        sql.append(       "f.name AS formula_name, ");
        sql.append(       "f.parameters AS formula_parameters, ");
        sql.append(       "c.id AS category_id, ");
        sql.append(       "c.name AS category_name ");
        sql.append("FROM medical_math.formula f, ");
        sql.append(     "medical_math.category c, ");
        sql.append(     "medical_math.formula_category fc ");
        sql.append("WHERE f.id = fc.formula_id ");
        sql.append("  AND c.id = fc.category_id;");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.query(sql.toString(), new FormulaRowMapper());
    }

    @Override
    public List<Formula> findAllByCategory(String categoryName) {
        StringBuilder sql = new StringBuilder();
        sql.append("select f.id as formula_id, ");
        sql.append("       f.name as formula_name, ");
        sql.append("       f.parameters as formula_parameters, ");
        sql.append("       c.id as category_id, ");
        sql.append("       c.name as category_name ");
        sql.append("from medical_math.formula f, ");
        sql.append("     medical_math.formula_category fc, ");
        sql.append("     medical_math.category c ");
        sql.append("where f.id = fc.formula_id ");
        sql.append("  and c.id = fc.category_id ");
        sql.append("  and c.name = :categoryName; ");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.query(sql.toString(), new Object[] { categoryName }, new FormulaRowMapper());
    }

}
