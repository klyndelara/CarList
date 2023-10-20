package com.KimlynsPractice.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcMembersDao implements MembersDao{
    private static JdbcTemplate jdbcTemplate;

    public JdbcMembersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
