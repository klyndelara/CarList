package com.KimlynsPractice.demo.controller;

import com.KimlynsPractice.demo.dao.MembersDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MemberController {

    private MembersDao membersDao; {
        this.membersDao = membersDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Member>
}

