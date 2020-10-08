package com.jkl.controller;

import com.jkl.TopicJson;
import com.jkl.bean.VO.ReturnVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Field;

import static com.jkl.TopicJson.MBTI93;

/**
 * @author zhongxin
 * @date 2020/10/8/008 18:22
 */
@RequestMapping("/exercise")
@Controller
public class ExerciseController {

    @RequestMapping(value = "/get/{name}",produces = "application/json")
    @ResponseBody
    public ReturnVO login(@PathVariable("name") String name, HttpServletRequest request, HttpSession session) {

        ReturnVO<String> returnVO = new ReturnVO<>();
        Class<TopicJson> fileDemoClass = TopicJson.class;
        Field field;
        try {
            field = fileDemoClass.getField(name);
            String data = (String) field.get(String.class);
            returnVO.setDatas(data);
        } catch (Exception e) {
            returnVO.setMsg("不存在的题目");
        }
        return returnVO;
    }
}
