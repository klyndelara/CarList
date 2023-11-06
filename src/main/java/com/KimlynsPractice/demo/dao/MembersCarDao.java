package com.KimlynsPractice.demo.dao;

import com.KimlynsPractice.demo.model.MembersCar;

import java.util.List;


public interface MembersCarDao {





    List<MembersCar> getMembersCar();

    MembersCar getMemberByMemberCarId(int memberCarId);


    int insertMembersCar(MembersCar membersCar);

    int deleteMemberCar(int memberCarId);
}
