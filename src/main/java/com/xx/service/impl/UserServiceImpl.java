package com.xx.service.impl;

import com.xx.mapper.UserMapper;
import com.xx.pojo.User;
import com.xx.service.IUserService;
import com.xx.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Description: TODO
 * @ClassName: UserServiceImpl
 * @Package: com.xx.service.impl
 * @Author: liu
 * @Date: 2023/5/7 22:54
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //通过user参数来获取传递过来的username
        User result = userMapper.findByUsername(user.getUsername());
        if (result != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }

        /*
         * 密码加密处理作用:
         * 1.后端不再能直接看到用户的密码2.忽略了密码原来的强度,提升了数据安全性
         * 密码加密处理的实现:
         * 串+password+串->交给md5算法连续加密三次
         * 串就是数据库字段中的盐值,是一个随机字符串
         */
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMD5Password(user.getPassword(), salt);

        //补全数据
        user.setPassword(md5Password);
        user.setSalt(salt);

        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //执行注册业务功能的实现
        Integer row = userMapper.insertUser(user);
        if (row != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }

    }

    @Override
    public User login(String username, String password) {

        User result = userMapper.findByUsername(username);

        if (result == null) {
            throw new UsernameNotFoundException("用户数据不存在");
        }
        String oldPassword = result.getPassword();
        String salt = result.getSalt();

        String newMd5Password = getMD5Password(password, salt);

        if (!oldPassword.equals(newMd5Password)) {
            throw new PasswordNotMatchException("用户密码错误");
        }
        if (result.getIsDelete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setPassword(result.getPassword());
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {

        User result = userMapper.findByUid(uid);

        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        String oldMd5Password = getMD5Password(oldPassword, result.getSalt());
        if (!result.getPassword().equals(oldMd5Password)) {
            throw new PasswordNotMatchException("密码错误");
        }

        String newMd5Password = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, new Date());

        if (rows != 1) {
            throw new UpdateException("更新数据产生未知的异常");
        }


    }

    @Override
    public User getByUid(Integer uid) {

        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        //可以直接返回result给控制层,但是太臃肿了
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        return user;
    }

    @Override
    public void changeInfo(Integer uid, User user) {

        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新数据时产生异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {

        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UsernameNotFoundException("用户数据不存在");
        }

        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());

        if (rows != 1) {
            throw new UpdateException("更新用户头像时产生未知异常");
        }
    }

    /**
     * md5加密算法
     *
     * @param password
     * @param salt
     * @return: java.lang.String
     * @Author: liu
     * @Date: 2023/5/7 23:31
     */
    public String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();

        }
        return password;
    }


}
