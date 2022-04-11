package framework.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import framework.common.service.LoginService;

/**
 * @author wzq
 * Created on 2022-04-10
 */

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/sourceA")
    public String sourceA(){
        System.out.println("你正在访问资源A,service.test()前");
        System.out.println(loginService.test());
        System.out.println("你正在访问资源A,service.test()后");
        return "你正在访问资源A";
    }

    @GetMapping(value = "/sourceB")
    public String sourceB(){
        System.out.println("你正在访问资源B,service.test()前");
        System.out.println(loginService.test());
        System.out.println("你正在访问资源B,service.test()后");
        return "你正在访问资源B";
    }

}
