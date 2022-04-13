package framework.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import framework.Interceptor.SourceAccessInterceptor;


/**
 * @author wzq
 * Created on 2022-04-12
 */

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //可添加多个
        registry.addInterceptor(new SourceAccessInterceptor()).addPathPatterns("/**");
    }
}
