package com.aaa.lau.repast.fallback;

import com.aaa.lau.repast.base.ResultData;
import com.aaa.lau.repast.service.IRepastService;
import com.aaa.lau.repast.vo.TokenVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:17
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {


    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {

            public TokenVo doLogin(Map map) {
                System.out.println("熔断登录方法！");
                return null;
            }

            public ResultData saveLog(Map map) {
                System.out.println("熔断日志方法！");
                return null;
            }


            public Boolean uploadFile(MultipartFile file, String token) {
                System.out.println("熔断文件上传方法！");
                return null;
            }
        };
        return repastService;
    }

}