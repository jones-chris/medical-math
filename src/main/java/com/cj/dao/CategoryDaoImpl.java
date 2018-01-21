package com.cj.dao;


import com.cj.mappers.CategoryRowMapper;
import com.cj.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public Category findById(Long id) {
        // create sql
        String sql = "select * " +
                     "from medical_math.category " +
                     "where id = 1;";

        // initialize jdbcTemplate
        jdbcTemplate = new JdbcTemplate(dataSource, true);

        // pass sql to jdbcTemplate with rowMapper.
        return jdbcTemplate.queryForObject(sql, Category.class);
    }

    @Override
    public List<Category> findAll() {
        String sql = "select * " +
                     "from medical_math.category;";

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }
}
