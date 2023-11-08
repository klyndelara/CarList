package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.Members;

import java.util.List;

//Interface to define the intended functionality of the MembersDao.
//
// Classes that implement this interface carry the responsibility of defining HOW these methods return the values defined here.


public interface MembersDao {


    List<Members> getMembers();

    Members getMemberById(int memberId);

    Members getMemberByName(String name);

    int insertMember(Members member);

    int deleteMember(int memberId);
}
