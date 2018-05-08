package com.mrxu.cloud.user.study;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.Serializable;
import java.util.*;

/**
 * @author ifocusing-xuzhiwei
 * @since 2018/4/16
 */
public class UserDTO implements Serializable{
    private static final long serialVersionUID = -8404606657542111547L;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        UserDTO u1 = new UserDTO();
        u1.setName("XuZhiWei");
        u1.setAge(26);
        UserDTO u2 = new UserDTO();
        u2.setName("JiangLi");
        u2.setAge(25);
        UserDTO u3 = new UserDTO();
        u3.setName("Wenlin");
        u3.setAge(27);
        UserDTO u4 = new UserDTO();
        u4.setName("ZhangJiao");
        u4.setAge(23);
        List<UserDTO> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        Collections.sort(list, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(JSONObject.toJSONString(list));
    }
}
