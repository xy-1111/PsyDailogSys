package com.jkl.bean;

import javax.persistence.*;

/**
 * @author zhongxin
 * @date 2020/10/9/009 18:02
 */

@Entity
@Table(name = "tb_topic")
public class TopicBean {

    public TopicBean() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="topicId")
    private int topicId;

    @Column(name="topicName")
    private String topicName;

    @Column(name="topicContent")
    private String topicContent;

    @Column(name="topicRule")
    private String topicRule;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getTopicRule() {
        return topicRule;
    }

    public void setTopicRule(String topicRule) {
        this.topicRule = topicRule;
    }
}
