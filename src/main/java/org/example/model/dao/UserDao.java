package org.example.model.dao;


import org.example.model.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDao {

    private static JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserByName(String username) {
        return jdbcTemplate.queryForObject(
                "select USERNAME, role, age, email, phone, password, bloodgroup, eligibility from USERSB where USERNAME = '" + username + "'",
                (resultSet, rowNum) -> {
                    User user = new User();
                    user.setUserName(resultSet.getString("USERNAME"));
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

    public String authorizeUser(String username,String password) {

        return jdbcTemplate.queryForObject(
                "select USERNAME  from USERSB where username = '" + username + "' and password = '" + password + "'",
                (resultSet, rowNum) -> {
                    User receive = new User();
                    receive.setUserName(resultSet.getString("USERNAME"));
                    return resultSet.getString("USERNAME");
                });
    }


    public void insertUser(User user) {

        jdbcTemplate.update("insert into USERSB(USERNAME, password, role, age, email, phone, bloodgroup, eligibility) values (?, ?, ?, ?, ?, ?, ?, ?)", user.getUserName(), user.getPassword(), user.getRole(), user.getAge(), user.getEmail(), user.getPhone(), user.getBg(), "YES");

    }

/*
    public void updateUser(User user) {
        jdbcTemplate.update("update USERSB set AGE = ?, EMAIL = ?, PHONE = ?, BLOODGROUP = ? where USERNAME = ?",  user.getAge(), user.getEmail(), user.getPhone(), user.getBg(), user.getUserName());
    }*/
    public void updateUser(User user) {
        jdbcTemplate.update("update USERSB set email = ?, phone = ?, age = ?, bloodgroup = ? where USERNAME = ?", user.getEmail(), user.getPhone(), user.getAge(), user.getBg(), user.getUserName());
    }

    /*
    String age, String email, String phone, String bg
    AGE	EMAIL	PHONE	BLOODGROUP	ELIGIBILITY	LASTBLOOD


    public void updatePass(User user) {
        jdbcTemplate.update("update USERSB set password = ? where USERNAME = ?", user.getPassword(), user.getUserName());
    }

    */


    public void updatePass(User user) {
        jdbcTemplate.update("update USERSB set password = ? where USERNAME = ?", user.getPassword(), user.getUserName());
    }

    public void updateEligibility(String eligibility, String username) {
        jdbcTemplate.update("update USERSB set eligibility = ? where USERNAME = ?", eligibility, username);
    }

    public void updateLastBlood(String lastBlood, String username) {
        jdbcTemplate.update("update USERSB set lastblood = ? where USERNAME = ?", lastBlood, username);
    }

    public static void deleteBlood(String username)
    {
        jdbcTemplate.update("DELETE FROM USERSB WHERE USERNAME = ? ", username);
    }



    public String showLastBlood(String username) {
        User user = new User();
        jdbcTemplate.queryForObject(
                "select lastblood  from USERSB where USERNAME = '" + username + "'",
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
