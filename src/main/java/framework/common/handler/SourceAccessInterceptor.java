package framework.common.handler;
/**
 * @author wzq
 * Created on 2022-04-10
 * servlet 引用报错问题参考 https://blog.csdn.net/a290450134/article/details/80964726
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SourceAccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法在业务处理器处理请求以前被调用");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法在业务处理器处理请求执行完成后，生成视图以前执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法在DispatcherServlet彻底处理完请求后被调用，可用于清理资源等");
    }
}
