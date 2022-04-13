package framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import framework.annotation.LoginRequired;
import framework.annotation.MyLog;
import framework.pojo.User;
import framework.service.LoginService;

/**
 * @author wzq
 * Created on 2022-04-10
 */

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @LoginRequired
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

    @MyLog
    @GetMapping(value = "/sourceC/{source_name}")
    public String sourceC(@PathVariable("source_name") String sourceName){

        return "你正在访问资源C";
    }

    @MyLog
    @PostMapping(value = "/sourceD/test")
    public String sourceD(@RequestBody User user){
        return "正在访问D "+ String.valueOf(user);
    }

}
