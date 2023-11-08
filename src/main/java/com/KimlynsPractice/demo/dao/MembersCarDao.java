package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.MembersCar;

import java.util.List;

//Interface to define the intended functionality of the MembersCarDao.
//
// Classes that implement this interface carry the responsibility of defining HOW these methods return the values defined here.


public interface MembersCarDao {





    List<MembersCar> getMembersCar();

    MembersCar getMemberByMemberCarId(int memberCarId);


    int insertMembersCar(MembersCar membersCar);

    int deleteMemberCar(int memberCarId);
}
