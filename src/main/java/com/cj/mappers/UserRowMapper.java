package com.cj.mappers;

import com.cj.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));

        user.getRoles().add(rs.getString("role_name"));

//        // Only add roles that do not exist in the roles collection already
//        if (! user.getRoles().contains(rs.getString("role_name"))) {
//            user.getRoles().add(rs.getString("role_name"));
//        }

        //TODO: cj Kind of a hack...is there a more elegant way to do this?
        Array favorites = rs.getArray("formula_id");
        ResultSet set = favorites.getResultSet();
        set.last();
        int numOfRows = set.getRow();
        for (int i=0; i<numOfRows; i++) {
            user.getFavorites().add(set.getLong(2));
        }

        return user;
    }
}
