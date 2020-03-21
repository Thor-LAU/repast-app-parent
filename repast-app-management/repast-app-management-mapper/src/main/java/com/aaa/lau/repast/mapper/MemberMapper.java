package com.aaa.lau.repast.mapper;

import com.aaa.lau.repast.model.Member;
import org.springframework.web.bind.annotation.PostMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-10 19:33
 **/

public interface MemberMapper extends Mapper<Member> {

    Member selectMemberByOpenId(String openId);

    Map selectMemberById(Long Id);

}
