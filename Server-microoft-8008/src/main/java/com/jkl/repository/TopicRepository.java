package com.jkl.repository;

import com.jkl.bean.TopicBean;
import com.jkl.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhongxin
 * @date 2020/10/9/009 18:06
 */
public interface TopicRepository extends JpaRepository<TopicBean, String> {

    @Query(value = "from TopicBean t where t.topicName = :name")
    TopicBean getTopicByName(@Param("name")String name);

    @Query(value = "select t.topicName from tb_topic t",nativeQuery = true)
    List<String> listTopicName();

}
