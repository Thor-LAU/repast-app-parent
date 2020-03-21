package com.aaa.lau.repast.config;

import com.aaa.lau.repast.utils.GetParamsUtil;
import com.aaa.lau.repast.utils.PostParamsUtil;
import com.aaa.lau.repast.utils.SendParams2ControllerUtil;
import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static com.aaa.lau.repast.staticstatus.RequestProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/17 11:50
 * @Description
 *      路由过滤器
 **/
@Component
public class TokenFilter extends ZuulFilter {

    /**
     * @author Seven Lee
     * @description
     *      路由过滤器类型
     *          一共只有四个值:
     *              1.pre:到达路由之前所需要执行
     *              2.routing:在到达路由的时候执行
     *              3.post:在路由之后执行
     *              4.error:发生异常的时候执行(通常使用统一异常处理)
     * @param
     * @date 2020/3/17
     * @return java.lang.String
     * @throws
    **/
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @author Seven Lee
     * @description
     *      路由过滤器的顺序
     *      如果只有一个过滤器就无所谓了，怎么配都可以开心就好
     *      如果有多个过滤器并且必须要按照某种顺序执行的时候，就需要严谨配置
     *      返回的是一个int类型，代表了优先级:
     *          数字越大，优先级越低
     * @param
     * @date 2020/3/17
     * @return int
     * @throws
    **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @author Seven Lee
     * @description
     *      是否应该启用过滤器
     *      目前咱们的过滤器是验证token的，也就是说当用户要进行登录操作的时候是没有token值的
     *      这个过滤器就不需要执行
     *      true:启用过滤器
     *      false:禁用过滤器
     *      1.路由过滤器默认是无法获取post请求数据，只能获取get(InputStream,重写InputStream)
     *      request.getParameter("token");--->绝对获取不到
     *      2.路由过滤器默认不会把参数传递到目标controller(重写request)
     * @param
     * @date 2020/3/17
     * @return boolean
     * @throws
    **/

    public boolean shouldFilter() {
        // 1.获取request的上下文对象(不要去new对象，因为new出来的对象一定是空的，无论什么时候都必须从当前线程中获取当前的上下文)
        RequestContext rcx = RequestContext.getCurrentContext();
        // 2.获取HTTPServletRequest对象
        HttpServletRequest request = rcx.getRequest();
        // 3.获取客户端的url访问地址
        // request.getRequestURI();// 以项目为根目录获取项目中的路径--->http://localhost:4081/项目名/aaa/seven/doLogin---http://localhost:4081/项目名-->转换为、
        String url = request.getRequestURL().toString();// 客户端的访问路径--->localhost:4081/aaa/seven/**
        // 4.判断客户端访问路径中是否包含了"http://"和"/doLogin"
        JSONObject paramsObject = new JSONObject();
        if(url.contains(DO_LOGIN_URL) && (url.contains(HTTP_URL) || url.contains(HTTPS_URL))) {
            // 说明请求是登录请求，不需要过滤，直接放行
            // 获取客户端传递过来的对象信息--->再把这个对象信息返回给目标controller
            // 5.判断客户端的请求方式(POST和GET)(if和else if不能使用else)
            String method = request.getMethod().toUpperCase();// 请求方式(GET/POST)
            if(method.equals(GET_URL)) {
                // 以get的请求方式获取参数
                paramsObject = GetParamsUtil.getParams(request);

            } else if(method.equals(POST_URL)) {
                // 以POST的形式获取请求参数(Post不像Get，直接追加在地址栏中，Post以对象文本域流的形式来进行发送)
                // 序列化的作用就是把实体类能够转换二进制流--->在http协议中以POST的形式进行传输
                // 如果要获取到POST请求参数就必须要拿到流(输入流)对象--->这个流中就有需要的参数
                // 通过输入流再进一步转换--->字节数组--->json对象
                paramsObject = PostParamsUtil.getPrams(rcx);
            }

            // 6.把参数发送到controller中
            SendParams2ControllerUtil.sendParams(paramsObject, rcx, request);
            return false;
        }
        return true;
    }

    /**
     * @author Seven Lee
     * @description
     *      路由过滤器的具体业务
     *      也就是说实现了验证token
     * @param
     * @date 2020/3/17
     * @return java.lang.Object
     * @throws
    **/

    public Object run() throws ZuulException {
        // TODO 暂未完成
//        RequestContext rcx = RequestContext.getCurrentContext();
//        HttpServletRequest request = rcx.getRequest();
//        String url = request.getRequestURL().toString();
//        JSONObject paramsObject = new JSONObject();
        return null;
    }
}
