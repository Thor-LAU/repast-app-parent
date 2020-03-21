package com.aaa.lau.repast.service;

import com.aaa.lau.repast.base.BaseService;
import com.aaa.lau.repast.mapper.MemberMapper;
import com.aaa.lau.repast.model.Member;
import com.aaa.lau.repast.utils.IDUtil;
import com.aaa.lau  .repast.utils.StringUtil;
import com.aaa.lau.repast.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

import static com.aaa.lau.repast.staticstatus.RequestProperties.TOKEN;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:54
 * @Description
 **/
@Service
public class MemberService extends BaseService<Member> {

    @Autowired
    private MemberMapper memberMapper;

//    @Override
//    public Mapper<Member> getMapper() {
//        return memberMapper;
//    }
    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }

    public TokenVo doLogin(Map map) {
        TokenVo tokenVo = new TokenVo();
        /**
         * map:
         *  map.put("file", File);
         *  map.put("token", "dasjfakhfk);
         */
        if(null == map) {
            return tokenVo.setIfSuccess(false).setToken(null);
        }
        if(null != map.get(TOKEN) && StringUtil.isNotEmpty((String)map.get(TOKEN))) {
            // map中包含的有token值，不能直接转换对象类型--->转换异常--->所以需要把token移除
            map.remove(TOKEN);
        }
        Member member = super.newInstance(map);
        // 1.判断member是否为null，并且还要判断openId是否为null
        if(null != member && null != member.getOpenId() && StringUtil.isNotEmpty(member.getOpenId())) {
            // 说明是从微信端跳转的请求
            // 2.需要再次确保是否是新用户(通过openId进行查询-->看用户是否存在)
            try {
                /**
                 * 这个member是由微信端传递过来的
                 *      nickname: zhangsan(微信名)
                 *      region: 郑州(地区)
                 *      openId: 微信的唯一标识符
                 *      ...
                 *      select xxx from member where nickname = 'zhangsan' and region = '郑州'...
                 *
                 *      用户修改微信名:
                 *          nickname:lisi
                 *      select xxx from member where nickname = 'lisi' and region = '郑州'...
                 */
                Member mb = memberMapper.selectMemberByOpenId(member.getOpenId()); // 必须要只根据openId查询(有两个东西是不变的1.openId,2.微信号)
                String token = IDUtil.getUUID() + member.getOpenId();
                // 3.判断查询的mb是否为null
                if(null != mb) {
                    // 说明并不是新用户，之前一定登陆过
                    // 只需要修改token即可
                    mb.setToken(token); // 这个token一定是新的token
                    Integer updateResult = super.update(mb);
                    if(updateResult > 0) {
                        // 说明已经修改成功
                        tokenVo.setToken(token).setIfSuccess(true);
                        return tokenVo;
                    }

                } else {
                    // 说明是新用户，需要执行的是insert操作
                    member.setToken(token);
                    Integer saveResult = super.add(member);
                    // 4.判断是否保存成功
                    if(saveResult > 0) {
                        // 保存成功
                        tokenVo.setToken(token).setIfSuccess(true);
                        return tokenVo;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tokenVo.setIfSuccess(false);
    }

    public Map selectMemberById(Long Id){
        if (Id != null){
            Map list = memberMapper.selectMemberById(Id);
            return list;
        }
        return null;
    }
}
