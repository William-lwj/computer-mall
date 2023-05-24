package com.xx.service;


import com.xx.pojo.User;
import com.xx.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: TODO
 * @ClassName: UserServiceTests
 * @Package: com.xx.service
 * @Author: liu
 * @Date: 2023/5/7 23:09
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("test04");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (SecurityException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());

        }

    }

    @Test
    public void login() {
        User user = userService.login("test05", "123");
        System.out.println(user);
    }

    @Test
    public void changePassword() {
        userService.changePassword(12,"管理员","123456","123");
    }

    @Test
    public void getByUid() {
        //err是为了让输出信息为红色
        System.err.println(userService.getByUid(12).getUsername());
    }

    @Test
    public void changeInfo() {
        User user = new User();
        //这四个属性值在真实开发中都是在控制层就已经自动封装在User对象中了
        //而uid需要由控制层传给业务层并在业务层封装到user中
        user.setPhone("123456789");
        user.setEmail("123456@qq.com");
        user.setUsername("管理员");
        user.setGender(0);
        userService.changeInfo(12,user);
    }

    @Test
    public void changeAvatar() {
        userService.changeAvatar(19,"test.png","test05");
    }

}
