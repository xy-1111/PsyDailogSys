package com.jkl.service.impl;

import com.jkl.bean.UserBean;
import com.jkl.repository.UserRepository;
import com.jkl.service.IUserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author zhongxin
 * @date 2020/10/8/008 15:11
 */
@Service
public class UserActionServiceImpl implements IUserActionService {

    @Autowired
    private UserRepository userRepository;

    public UserBean userLogin(String name) {
        UserBean user = userRepository.findUserByUsername(name);
        if(user == null)
        {
            user = new UserBean(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()),name);
            userRepository.save(user);
        }
        return user;

    }
}
