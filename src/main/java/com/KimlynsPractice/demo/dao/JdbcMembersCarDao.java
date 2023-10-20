package com.KimlynsPractice.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcMembersCarDao implements MembersCarDao{
    private static JdbcTemplate jdbcTemplate;

    public JdbcMembersCarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
