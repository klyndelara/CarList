package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Members;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcMembersDao implements MembersDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcMembersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Members> getMembers() {
        List<Members> members = new ArrayList<>();
        String membersSql = "Select * From members;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(membersSql);
            while (results.next()) {
                Members member = mapRowToMembers(results);
                members.add(member);
            }

        }catch (CannotGetJdbcConnectionException e){
            System.out.println(e.getMessage());
        }
        return members;
    }

    @Override
    public Members getMemberById(int memberId){
        String sql = "Select * from members where member_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, memberId);
        if (results.next()) {
            return mapRowToMembers(results);
        }else {
            return null;
        }
    }

    @Override
    public Members getMemberByName (String name) {
        String sql = "Select name from members where name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if (results.next()) {
            return mapRowToMembers(results);
        }else{
            return null;
        }
    }

    @Override
    public int insertMember(Members member) {
        String sql = "Insert into member (name, phone_number, address, city, state, zipcode " +
                "values (?, ?, ?. ?, ? ,?) returning member_id;";
        int newMemberId = jdbcTemplate.queryForObject(sql, int.class, member.getName(), member.getPhoneNumber(), member.getAddress(),
                member.getCity(), member.getState(), member.getZipCode());
        return newMemberId;
    }

    @Override
    public int deleteMember(int memberId) {
        String sql = "Delete from memberscar where member_id = ?";
        jdbcTemplate.update(sql, memberId);
        sql = "Delete from members where member_id = ?";
        jdbcTemplate.update(sql, memberId);
        return memberId;
    }

    private Members mapRowToMembers (SqlRowSet rowSet){
        Members members = new Members();
        members.setMembersId(rowSet.getInt("member_id"));
        members.setName(rowSet.getString("name"));
        members.setPhoneNumber(rowSet.getString("phone_number"));
        members.setAddress(rowSet.getString("address"));
        members.setCity(rowSet.getString("city"));
        members.setState(rowSet.getString("state"));
        members.setZipCode(rowSet.getString("zipcode"));
        return members;
    }




}