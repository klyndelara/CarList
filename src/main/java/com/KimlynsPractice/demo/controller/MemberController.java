package com.KimlynsPractice.demo.controller;

import com.KimlynsPractice.demo.dao.MembersDao;
import com.KimlynsPractice.demo.model.Members;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Member;
import java.util.List;
@RestController
@RequestMapping("/members")
@CrossOrigin

public class MemberController {
    private MembersDao membersDao;
    private MemberController (MembersDao membersDao) {
        this.membersDao = membersDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Members> getMembers() { return membersDao.getMembers();}

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Members getMember(@PathVariable int id) {
        Members members = membersDao.getMemberById(id);
        if (members == null) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Member Not Found");
        }else {
            return members;
        }
    }
    @RequestMapping(path = " ", method = RequestMethod.POST)
    public Members create (@RequestBody Members member){
        int memberId = membersDao.insertMember(member);
        return membersDao.getMemberById(memberId);

    }

  @RequestMapping (path = "/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable int id) {
        membersDao.deleteMember(id);
  }

}

