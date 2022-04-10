package framework.common;

import framework.common.factory.userFactory;
import framework.common.pojo.User;

/**
 * @author wangzhiqiang05
 * Created on 2022-04-10
 */
public class App {
    public static void main(String[] args) {
        User user = userFactory.create();
        user.setAge("30");
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }


}
