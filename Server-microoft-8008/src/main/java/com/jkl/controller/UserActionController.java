package com.jkl.controller;

import com.jkl.Utils.DataCheckUtil;
import com.jkl.bean.UserBean;
import com.jkl.bean.VO.ReturnVO;
import com.jkl.service.IUserActionService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author zhongxin
 * @date 2020/10/8/008 14:26
 */
@RequestMapping("/user_action")
@Controller
public class UserActionController {


    @Autowired
    private IUserActionService userActionService;

    @RequestMapping(value = "/login/{name}",produces = "application/json")
    @ResponseBody
    public ReturnVO login(@PathVariable("name") String name, HttpServletRequest request){
        ReturnVO<Object> returnVO = new ReturnVO<>();
        if(DataCheckUtil.isEmptyString(name))
        {
            returnVO.setMsg("名字不为空");
            return  returnVO;
        }
        UserBean userBean = userActionService.userLogin(name);
        returnVO.setDatas(userBean);
        return returnVO;
    }
}
