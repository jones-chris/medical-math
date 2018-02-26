package com.cj.mappers;

import com.cj.model.Category;
import com.cj.model.Formula;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class FormulaRowMapper implements RowMapper<Formula> {
    @Override
    public Formula mapRow(ResultSet rs, int rowNum) throws SQLException {
        Formula formula = new Formula();
        formula.setId(rs.getLong("formula_id"));
        formula.setName(rs.getString("formula_name"));
        formula.setParentId(rs.getLong("formula_parent_id"));
        formula.setHasChildren(rs.getBoolean("formula_has_children"));

//        String[] formulaParamsList = rs.getString("formula_parameters").split(",");
//        formula.setParameters(formulaParamsList);

        Category category = new Category();
        category.setId(rs.getLong("category_id"));
        category.setName(rs.getString("category_name"));
        formula.setCategory(category);

        return formula;
    }
}
