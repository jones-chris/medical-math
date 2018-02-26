package com.cj.dao;


import com.cj.exceptions.SqlResultCountException;
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
    public List<Formula> findAllByCategory(Long categoryId) {
        StringBuilder sql = new StringBuilder();
//        sql.append("select f.id as formula_id, ");
//        sql.append("       f.name as formula_name, ");
//        sql.append("       f.parameters as formula_parameters, ");
//        sql.append("       c.id as category_id, ");
//        sql.append("       c.name as category_name ");
//        sql.append("from medical_math.formula f, ");
//        sql.append("     medical_math.formula_category fc, ");
//        sql.append("     medical_math.category c ");
//        sql.append("where f.id = fc.formula_id ");
//        sql.append("  and c.id = fc.category_id ");
//        sql.append("  and c.name = ?; ");
        sql.append("SELECT * ");
        sql.append("FROM medical_math.master_formula ");
        sql.append("WHERE category_id = ?;");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.query(sql.toString(), new Object[] { categoryId }, new FormulaRowMapper());
    }

    @Override
    public List<Formula> findAllChildFormulas(Long id) {
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT f.id AS formula_id, ");
//        sql.append("       f.name AS formula_name, ");
//        sql.append("       f.parameters AS formula_parameters, ");
//        sql.append("       f.parent_id AS formula_parent_id, ");
//        sql.append("       f.has_children AS formula_has_children,");
//        sql.append("       c.id AS category_id,");
//        sql.append("       c.name AS category_name ");
//        sql.append("FROM medical_math.formula f,");
//        sql.append("     medical_math.category c,");
//        sql.append("     medical_math.formula_category fc ");
//        sql.append("WHERE f.id = fc.formula_id ");
//        sql.append("  AND c.id = fc.category_id ");
//        sql.append("  AND f.parent_id = ?;");
        sql.append("SELECT * ");
        sql.append("FROM medical_math.master_formula ");
        sql.append("WHERE formula_parent_id = ?;");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.query(sql.toString(), new Object[] { id }, new FormulaRowMapper());
    }

    @Override
    public List<Formula> findAllParentFormulas() {
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT f.id AS formula_id, ");
//        sql.append("       f.name AS formula_name, ");
//        sql.append("       f.parameters AS formula_parameters, ");
//        sql.append("       f.parent_id AS formula_parent_id,");
//        sql.append("       f.has_children AS formula_has_children,");
//        sql.append("       c.id AS category_id,");
//        sql.append("       c.name AS category_name ");
//        sql.append("FROM medical_math.formula f, ");
//        sql.append("     medical_math.category c, ");
//        sql.append("     medical_math.formula_category fc ");
//        sql.append("WHERE f.id = fc.formula_id ");
//        sql.append("  AND c.id = fc.category_id ");
//        sql.append("  AND f.parent_id IS NULL;");
        sql.append("SELECT * ");
        sql.append("FROM medical_math.master_formula ");
        sql.append("WHERE formula_parent_id IS NULL ");
        sql.append("  AND formula_has_children = true;");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.query(sql.toString(), new FormulaRowMapper());
    }

    @Override
    public Formula findById(Long id) throws SqlResultCountException {
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT f.id AS formula_id, ");
//        sql.append("       f.name AS formula_name, ");
//        sql.append("       f.parameters AS formula_parameters, ");
//        sql.append("       f.parent_id AS formula_parent_id, ");
//        sql.append("       f.has_children AS formula_has_children,");
//        sql.append("       c.id AS category_id,");
//        sql.append("       c.name AS category_name ");
//        sql.append("FROM medical_math.formula f,");
//        sql.append("     medical_math.category c,");
//        sql.append("     medical_math.formula_category fc ");
//        sql.append("WHERE f.id = fc.formula_id ");
//        sql.append("  AND c.id = fc.category_id ");
//        sql.append("  AND f.id = ?;");
        sql.append("SELECT * ");
        sql.append("FROM medical_math.master_formula ");
        sql.append("WHERE formula_id = ?;");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        List<Formula> results = jdbcTemplate.query(sql.toString(), new Object[] {id}, new FormulaRowMapper());

        if (results != null) {
            if (results.size() == 1) {
                return results.get(0);
            } else {
                throw new SqlResultCountException(String.format("Expected 1 result, but query found %s results", results.size()));
            }
        } else {
            throw new SqlResultCountException(String.format("Expected 1 result, but query found %s results", results.size()));
        }
    }

}
