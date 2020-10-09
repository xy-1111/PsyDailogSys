package com.jkl.bean.DTO;

import java.io.Serializable;

/**
 * @author zhongxin
 * @date 2020/10/9/009 19:07
 */
public class TopicDataOptionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String option;//选项编号 例如A B C D 1 2 3 4
    private String content;

    public TopicDataOptionDTO() {
    }

    public TopicDataOptionDTO(String option, String content) {
        this.option = option;
        this.content = content;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
