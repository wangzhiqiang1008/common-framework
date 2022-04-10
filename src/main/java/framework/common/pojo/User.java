package framework.common.pojo;

import framework.common.Init;

/**
 * @author wangzhiqiang05
 * Created on 2022-04-10
 */
public class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    @Init("louis")
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    @Init("22")
    public User setAge(String age) {
        this.age = age;
        return this;
    }
}
