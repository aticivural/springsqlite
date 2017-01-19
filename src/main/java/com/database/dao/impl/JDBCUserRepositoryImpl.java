package com.database.dao.impl;

import com.database.dao.UserRepository;
import com.database.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vural on 19-Jan-17.
 */
@Component
public class JDBCUserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCUserRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserById(Integer id) {
        User user;
        RowMapper<User> userRowMapper = new UserRowMapper();
        String SQL = "select * from User where id = ?";
        try {
            user = jdbcTemplate.queryForObject(SQL, userRowMapper, id);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    private class UserRowMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return mapUser(resultSet);
        }
    }

    private User mapUser(ResultSet resultSet) throws SQLException {
        User user = null;
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");


        user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }
}
