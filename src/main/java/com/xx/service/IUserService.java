package com.xx.service;

import com.xx.pojo.User;

/**
 * @Description: 用户模块业务层接口
 * @ClassName: IUserService
 * @Package: com.xx.service
 * @Author: liu
 * @Date: 2023/5/7 22:52
 * @Version: 1.0
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     * @return: void
     * @Author: liu
     * @Date: 2023/5/7 22:54
    */
    void reg(User user);
    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @return: 前匹配的用户数据,如果没有则返回null
     * @Author: liu
     * @Date: 2023/5/9 11:03
    */
    User login(String username,String password);

    /** 
     * 用户修改密码
     * @param uid 
     * @param username 
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return: void
     * @Author: liu
     * @Date: 2023/5/9 22:11
    */
    void changePassword(Integer uid, String username,
                        String oldPassword, String newPassword);

    /**
     * 根据用户的uid查询用户数据
     * @param uid 用户uid
     * @return 用户数据
     * @Author: liu
     * @Date: 2023/5/10 14:36
    */
    User getByUid(Integer uid);

    /** 
     * uid通过控制层在session中获取然后传递给业务层,并在业务层封装到User对象中
     * @param uid 
     * @param user 
     * @return: void
     * @Author: liu
     * @Date: 2023/5/10 14:38
    */
    void changeInfo(Integer uid, User user);
    
    /**
     * 修改用户的头像
     * @param uid 用户uid
     * @param avatar 用户头像的路径
     * @param username 用户名称
     * @return: void
     * @Author: liu
     * @Date: 2023/5/10 16:48
    */
    void changeAvatar(Integer uid, String avatar, String username);

}
