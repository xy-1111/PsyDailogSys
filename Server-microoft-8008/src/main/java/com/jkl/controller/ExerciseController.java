package com.jkl.controller;

import com.jkl.TopicJson;
import com.jkl.Utils.TopicFileHandleUtil;
import com.jkl.bean.VO.ReturnVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

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
    public ReturnVO getTopic(@PathVariable("name") String name, HttpServletRequest request, HttpSession session) {

        ReturnVO<ArrayList<Map>> returnVO = new ReturnVO<>();
//        Class<TopicJson> fileDemoClass = TopicJson.class;
//        Field field;
        //            field = fileDemoClass.getField(name);

        ArrayList<Map> mbti93 = TopicFileHandleUtil.getMBTI93();
        returnVO.setDatas(mbti93);

        return returnVO;
    }

    @RequestMapping(value = "/gets",produces = "application/json")
    @ResponseBody
    public ReturnVO getAllTopicName(HttpServletRequest request, HttpSession session) {
        ReturnVO<ArrayList> returnVO = new ReturnVO<>();
        Class<TopicJson> fileDemoClass = TopicJson.class;
        Field[] fields = fileDemoClass.getFields();
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            names.add(fields[i].getName());
        }
        returnVO.setDatas(names);
        return returnVO;
    }
}
