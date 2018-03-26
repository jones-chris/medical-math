package com.cj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

@Repository
public class LookupDaoImpl implements LookupDao {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getDbVersion() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT value ");
        sql.append("FROM medical_math.lookups ");
        sql.append("WHERE name = 'version';");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.queryForMap(sql.toString());
    }
}
