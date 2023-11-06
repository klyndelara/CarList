package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.MembersCar;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMembersCarDao implements MembersCarDao{
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public JdbcMembersCarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public  List<MembersCar> getMembersCar() {
        List<MembersCar> membersCars = new ArrayList<>();
        String membersCarSql = "Select * from memberscar;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(membersCarSql);
            while (results.next()) {
                MembersCar membersCar = mapRowToMembersCar(results);
                membersCars.add(membersCar);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println(e.getMessage());
        }
        return membersCars;
    }
    @Override
    public MembersCar getMemberByMemberCarId(int memberCarId){
        String sql = "Select * from memberscar where member_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, memberCarId);
        if (results.next()) {
            return mapRowToMembersCar(results);
        }else{
            return null;
        }
    }

    @Override
    public int insertMembersCar(MembersCar membersCar){
        String sql = "Insert into memberscar (member_id, car_id, color) " +
                "values (?,?,?) returning memberscar_id;";
        int newMemberCarId = jdbcTemplate.queryForObject(sql, int.class, membersCar.getMemberId(), membersCar.getCarId(),
        membersCar.getColor());
        return newMemberCarId;

    }
    @Override
    public int deleteMemberCar( int memberCarId) {
        String sql = "Delete from memberscar where memberscar_id = ?";
        jdbcTemplate.update(sql, memberCarId);
        return memberCarId;
    }


    private MembersCar mapRowToMembersCar (SqlRowSet rowSet){
        MembersCar membersCar = new MembersCar();
        membersCar.setMemberCarId(rowSet.getInt("memberscar_id"));
        membersCar.setMemberId(rowSet.getInt("members_id"));
        membersCar.setCarId(rowSet.getInt("car_id"));
        membersCar.setColor(rowSet.getString("color"));
        return membersCar;
    }

}

