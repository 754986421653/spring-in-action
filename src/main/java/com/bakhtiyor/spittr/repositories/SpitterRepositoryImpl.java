package com.bakhtiyor.spittr.repositories;

import com.bakhtiyor.spittr.models.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public SpitterRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Spitter save(Spitter spitter) {
        jdbc.update(
                "insert into Spitter (username, password, first_name, last_name) values (?, ?, ?, ?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName()
        );
        return spitter; // TODO: Determine value for id
    }

    @Override
    public Spitter findOneByUsername(String username) {
        return jdbc.queryForObject(
                "select id, username, first_name, last_name from Spitter where username = ?",
                new SpitterRowMapper(),
                username
        );
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    null,
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );
        }
    }
}
