package com.KimlynsPractice.demo.controller;

import com.KimlynsPractice.demo.dao.MembersCarDao;
import com.KimlynsPractice.demo.model.Members;
import com.KimlynsPractice.demo.model.MembersCar;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/memberscar")
@CrossOrigin
public class MembersCarController {

    private MembersCarDao membersCarDao; {
        this.membersCarDao = membersCarDao;
    }

@RequestMapping(path = " ", method = RequestMethod.GET)
public List<MembersCar> getMembersCar() { return membersCarDao.getMembersCar(); }

@RequestMapping(path = " ", method = RequestMethod.GET)
public MembersCar getMemberByMemberCarId(@PathVariable int id) {
        MembersCar membersCar = membersCarDao.getMemberByMemberCarId(id);
        if(membersCar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Member Car Not Found");
        }else{
            return membersCar;
        }
}

@RequestMapping(path = " ", method = RequestMethod.POST)
public MembersCar create (@RequestBody MembersCar membersCar){
        int memberCarId = membersCarDao.insertMembersCar(membersCar);
        return membersCarDao.getMemberByMemberCarId(memberCarId);

    }
@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteMemberCar(@PathVariable int id) {membersCarDao.deleteMemberCar(id);}


}
