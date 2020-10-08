package com.jkl.controller;

import com.jkl.TopicJson;
import com.jkl.bean.VO.ReturnVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.jkl.TopicJson.MBTI93;

/**
 * @author zhongxin
 * @date 2020/10/8/008 18:22
 */
@RequestMapping("/exercise")
public class ExerciseController {

    @RequestMapping(value = "/get/{name}",produces = "application/json")
    @ResponseBody
    public ReturnVO login(@PathVariable("name") String name, HttpServletRequest request, HttpSession session) {
        ReturnVO<String> returnVO = new ReturnVO<>();
        returnVO.setDatas(MBTI93);
        return returnVO;
    }
}
