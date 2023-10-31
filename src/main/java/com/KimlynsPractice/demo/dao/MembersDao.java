package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Members;

import java.util.List;

public interface MembersDao {


    List<Members> getMembers();

    Members getMemberById(int memberId);

    int insertMember(Members member);

    int deleteMember(int memberId);
}
