package org.example.model.dao;


import org.example.model.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserById(int userId) {
        return this.jdbcTemplate.queryForObject(
                "select username, role, age, email, phone, password, bloodgroup, eligibility from users where user_id = '" + userId + "'",
                (resultSet, rowNum) -> {
                    User user = new User();
                    user.setUserName(resultSet.getString("username"));
                    user.setRole(resultSet.getString("role"));
                    user.setAge(resultSet.getString("age"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setPassword(resultSet.getString("password"));
                    user.setBg(resultSet.getString("bloodgroup"));
                    user.setEligibility(resultSet.getString("eligibility"));
                    return user;
                });
    }

    public User authorizeUser(User user) {

        return this.jdbcTemplate.queryForObject(
                "select user_id  from users where username = '" + user.getUserName() + "' and password = '" + user.getPassword() + "'",
                (resultSet, rowNum) -> {
                    User recieve = new User();
                    recieve.setUserId(resultSet.getInt("user_id"));
                    return recieve;
                });
    }

    public void insertUser(User user) {

        jdbcTemplate.update("insert into users(username, password, role, age, email, phone, bloodgroup, eligibility) values (?, ?, ?, ?, ?, ?, ?, ?)", user.getUserName(),
                user.getPassword(), user.getRole(), user.getAge(), user.getEmail(), user.getPhone(), user.getBg(), user.getEligibility());

    }


    public void updateUser(User user) {
        jdbcTemplate.update("update users set username =  ?,email = ?, phone = ?, age = ?, bloodgroup = ? where user_id = ?", user.getUserName(),
                 user.getEmail(), user.getPhone(), user.getAge(), user.getBg(), user.getUserId());
    }

    public void updatePass(User user) {
        jdbcTemplate.update("update users set password = ? where user_id = ?", user.getPassword(), user.getUserId());
    }

    public void updateEligibility(String eligibility, int userId) {
        jdbcTemplate.update("update users set eligibility = ? where user_id = ?", eligibility, userId);
    }

    public void updateLastBlood(String lastBlood, int userId) {
        jdbcTemplate.update("update users set lastblood = ? where user_id = ?", lastBlood, userId);
    }

    public String showLastBlood(int userId) {
        User user = new User();
        this.jdbcTemplate.queryForObject(
                "select lastblood  from users where user_id = '" + userId + "'",
                (resultSet, rowNum) -> {

                    if(resultSet.getString("lastblood") == null)
                        user.setLastBlood("NULL");
                    else
                        user.setLastBlood(resultSet.getString("lastblood"));
                    return user;
                });
        return user.getLastBlood();
    }
}
