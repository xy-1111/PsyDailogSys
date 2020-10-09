package com.jkl.bean.DTO;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhongxin
 * @date 2020/10/9/009 19:07
 */
public class TopicDataDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int number;
    private String question;
    private List<TopicDataOptionDTO> topicDataOptionDTOs;

    public TopicDataDTO() {
    }

    public TopicDataDTO(int number, String question, List<TopicDataOptionDTO> topicDataOptionDTOs) {
        this.number = number;
        this.question = question;
        this.topicDataOptionDTOs = topicDataOptionDTOs;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<TopicDataOptionDTO> getTopicDataOptionDTOs() {
        return topicDataOptionDTOs;
    }

    public void setTopicDataOptionDTOs(List<TopicDataOptionDTO> topicDataOptionDTOs) {
        this.topicDataOptionDTOs = topicDataOptionDTOs;
    }
}
