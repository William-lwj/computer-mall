package com.xx.mapper;

import com.xx.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Description: TODO
 * @ClassName: UserMapperTests
 * @Package: com.xx.mapper
 * @Author: liu
 * @Date: 2023/5/7 18:32
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");
        System.out.println(userMapper.insertUser(user));
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(10, "321", "管理员", new Date());
    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(10));
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(12);
        user.setPhone("100086");
        user.setEmail("123456@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid() {
        userMapper.updateAvatarByUid(19, "abc", "管理员", new Date());
    }



}
