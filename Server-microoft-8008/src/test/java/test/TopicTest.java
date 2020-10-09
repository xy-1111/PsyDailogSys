package test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jkl.PsyDailogSysServiceApp;
import com.jkl.Utils.TopicFileHandleUtil;
import com.jkl.bean.DTO.TopicDataDTO;
import com.jkl.bean.TopicBean;
import com.jkl.repository.TopicRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongxin
 * @date 2020/10/9/009 18:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PsyDailogSysServiceApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicTest {

    @LocalServerPort
    private int port;

    private URL base;
    @Autowired
    private TopicRepository topicRepository;
    @Test
    public void testTopic(){

//        TopicBean topicBean = new TopicBean();
//        String mbti93 = TopicFileHandleUtil.getMBTI93();
//        topicBean.setTopicContent(mbti93);
//        topicBean.setTopicName("MBTI93");
//        TopicBean save = topicRepository.save(topicBean);
        TopicBean m = topicRepository.getTopicByName("MBTI93");
        List<TopicDataDTO> s = new Gson().fromJson(m.getTopicContent(), new TypeToken<List<TopicDataDTO>>() {
        }.getType());
        System.out.println(s);
    }

}
