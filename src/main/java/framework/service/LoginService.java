package framework.service;

import org.springframework.stereotype.Service;

/**
 * @author wzq
 * Created on 2022-04-12
 */

@Service
public class LoginService {
    public String test(){
        System.out.println("这里是service.test()");
        return "test()";
    }
}
