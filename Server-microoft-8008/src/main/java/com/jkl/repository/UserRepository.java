package com.jkl.repository;

import com.jkl.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhongxin
 * @date 2020/10/6/006 23:37
 */
public interface UserRepository extends JpaRepository<UserBean, String> {

    @Query(value="from UserBean as u where u.userId = :id")
    UserBean findUserById(@Param("id") int id);

    @Query(value = "from UserBean ")
    List<UserBean> listUsers();
}
