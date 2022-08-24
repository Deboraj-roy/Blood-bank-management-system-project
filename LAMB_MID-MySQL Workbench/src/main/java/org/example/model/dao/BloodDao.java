package org.example.model.dao;


import org.example.model.entities.Blood;
import org.example.model.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BloodDao {

    private JdbcTemplate jdbcTemplate;

    public BloodDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Blood> getAllBlood() {
        return this.jdbcTemplate.query(
                "select * from bloods",
                (resultSet, rowNum) -> {
                    Blood blood = new Blood();
                    blood.setBloodId(resultSet.getInt("blood_id"));
                    blood.setDonorId(resultSet.getInt("donor_id"));
                    blood.setPlatelet(resultSet.getInt("plateletcount"));
                    blood.setHaemoglobin(resultSet.getDouble("haemoglobin"));
                    blood.setLymphocytes(resultSet.getInt("lymphocytes"));

                    return blood;
                });
    }

    public Blood getBlood(String bloodId) {
        return this.jdbcTemplate.queryForObject(
                "select * from bloods where blood_id = "+bloodId,
                (resultSet, rowNum) -> {
                    Blood blood = new Blood();
                    blood.setBloodId(resultSet.getInt("blood_id"));
                    blood.setDonorId(resultSet.getInt("donor_id"));
                    blood.setPlatelet(resultSet.getInt("plateletcount"));
                    blood.setHaemoglobin(resultSet.getDouble("haemoglobin"));
                    blood.setLymphocytes(resultSet.getInt("lymphocytes"));
                    return blood;
                });
    }

    public void insertBlood(Blood blood) {

        jdbcTemplate.update("insert into bloods(donor_id, plateletcount, haemoglobin, lymphocytes) values (?, ?, ?, ?)", blood.getDonorId(),
                blood.getPlatelet(), blood.getHaemoglobin(), blood.getLymphocytes());
    }

}
