package test;

import com.jkl.PsyDailogSysServiceApp;
import com.jkl.bean.UserBean;
import com.jkl.service.impl.UserActionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

/**
 * @author zhongxin
 * @date 2020/10/8/008 15:48
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PsyDailogSysServiceApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserActionTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private UserActionServiceImpl userActionService;

    @Test
    public void testLogin(){
        UserBean userBean = userActionService.userLogin("zxxzxx");
        int userId = userBean.getUserId();
        System.out.println(userId);
    }

}
