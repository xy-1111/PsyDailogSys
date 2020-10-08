package com.jkl.controller;

import com.jkl.bean.UserBean;
import com.jkl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author zhongxin
 * @date 2020/10/6/006 21:09
 */
@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/service.do")
    public String service(String str){
        String s= "进入服务";
        return str+s;
    }
    @GetMapping("/get/{id}")
    @ResponseBody
    @Transactional
    public UserBean getUserInfo(@PathVariable("id") String userId) {
        int id = Integer.valueOf(userId);
        List<UserBean> userBean = userRepository.listUsers();
        return userBean.get(0);
    }

    @GetMapping("/getByid/{id}")
    @ResponseBody
    public UserBean getUser(@PathVariable("id") int userId){
        UserBean userBean = userRepository.findUserById(userId);
        return userBean;
    }
}
