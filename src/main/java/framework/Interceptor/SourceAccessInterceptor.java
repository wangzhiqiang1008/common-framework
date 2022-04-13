package framework.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import framework.annotation.LoginRequired;

/**
 * @author wzq
 * Created on 2022-04-10
 * servlet 引用报错问题参考 https://blog.csdn.net/a290450134/article/details/80964726
 * https://www.tqwba.com/x_d/jishu/394600.html
 */
public class SourceAccessInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法在业务处理器处理请求以前被调用");

        // 反射获取方法上的LoginRequred注解
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        LoginRequired loginRequired = handlerMethod.getMethodAnnotation(LoginRequired.class);
        if (loginRequired == null){
            return true;
        }

        System.out.println("request " + request.getRequestURI()) ;
        System.out.println("response " + response.getContentType()) ;

        // 有LoginRequired注解说明须要登陆，提示用户登陆
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print("你访问的资源须要登陆");
        return false;
    }
}
