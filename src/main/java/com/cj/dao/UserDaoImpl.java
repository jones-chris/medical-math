package com.cj.dao;

import com.cj.mappers.UserRowMapper;
import com.cj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByUsername(String username) throws EmptyResultDataAccessException {
        StringBuilder sql = new StringBuilder();
        sql.append("select u.username, array_agg(uf.formula_id) as formula_id, r.name as role_name ");
        sql.append("from medical_math.user u ");
        sql.append("left join medical_math.user_formula uf on u.username = uf.username ");
        sql.append("inner join medical_math.user_role ur on u.username = ur.username ");
        sql.append("inner join medical_math.role r on ur.role_id = r.id ");
        sql.append("where u.username = ? ");
        sql.append("group by u.username, r.name; ");

        jdbcTemplate = new JdbcTemplate(dataSource, true);

        return jdbcTemplate.queryForObject(sql.toString(), new Object[] {username}, new UserRowMapper());
    }

    @Override
    public boolean add(User user) {
        //TODO: CJ give database user INSERT priv to user table.
        StringBuilder sql = new StringBuilder();
        sql.append("insert into medical_math.user values (?, ?);");

        int affectedRows = jdbcTemplate.update(sql.toString(), user.getUsername(), user.getPassword());

        return (affectedRows == 1) ? true : false;
    }

    @Override
    public boolean updatePassword(User user) {
        //TODO:  CJ decide if we want to allow users to change their passwords or not.
        return false;
    }

    @Override
    public boolean addFavorite(Long id, User user) {
        // TODO:  CJ give database user INSERT priv to user_formula table.
        StringBuilder sql = new StringBuilder();
        sql.append("insert into medical_math.user_formula ");
        sql.append("values (?, ?);");

        int affectedRows = jdbcTemplate.update(sql.toString(), user.getUsername(), id);

        return (affectedRows == 1) ? true : false;
    }

    @Override
    public boolean deleteFavorite(Long id, User user) {
        // TODO:  CJ give database user DELETE priv to user_formula table.
        StringBuilder sql = new StringBuilder();
        sql.append("delete from medical_math.user_formula" );
        sql.append("where username = ? ");
        sql.append("formula_id = ?;");

        int affectedRows = jdbcTemplate.update(sql.toString(), user.getUsername(), id);

        return (affectedRows == 1) ? true : false;
    }
}
