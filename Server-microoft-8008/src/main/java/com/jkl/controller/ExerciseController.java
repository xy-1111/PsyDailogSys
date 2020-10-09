package com.jkl.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jkl.bean.DTO.TopicDataDTO;
import com.jkl.bean.VO.ReturnVO;
import com.jkl.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;


/**
 * @author zhongxin
 * @date 2020/10/8/008 18:22
 */
@RequestMapping("/exercise")
@Controller
public class ExerciseController {
    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping(value = "/get/{name}",produces = "application/json")
    @ResponseBody
    public ReturnVO getTopic(@PathVariable("name") String name, HttpServletRequest request, HttpSession session) {

        ReturnVO<List<TopicDataDTO>> returnVO = new ReturnVO<>();
        List<String> all = topicRepository.listTopicName();
        List<TopicDataDTO> datas = null;
        if(all.contains(name))
            datas = new Gson().fromJson(topicRepository.getTopicByName(name).getTopicContent(), new TypeToken<List<TopicDataDTO>>(){}.getType());
        else
            returnVO.setMsg("不存在的题目");
        returnVO.setDatas(datas);
        return returnVO;
    }

    @RequestMapping(value = "/gets",produces = "application/json")
    @ResponseBody
    public ReturnVO getAllTopicName(HttpServletRequest request, HttpSession session) {
        ReturnVO<List> returnVO = new ReturnVO<>();
        List<String> all = topicRepository.listTopicName();
        returnVO.setDatas(all);
        return returnVO;
    }
}
