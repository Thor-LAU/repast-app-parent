package com.aaa.lau.repast.controller;

import com.aaa.lau.repast.model.Member;
import com.aaa.lau.repast.service.MemberService;
import com.aaa.lau.repast.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/doLogin")
    public TokenVo doLogin(@RequestBody Map map) {
        return memberService.doLogin(map);
    }

}

