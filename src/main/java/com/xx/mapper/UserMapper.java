package com.xx.mapper;

import com.xx.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @Description: TODO
 * @ClassName: UserMapper
 * @Package: com.xx.mapper
 * @Author: liu
 * @Date: 2023/5/7 17:45
 * @Version: 1.0
 */
public interface UserMapper {

    /**
     * Description: 插入用户的数据
     * @param user
     * @return: 受影响的行数
     * @Author: liu
     * @Date: 2023/5/7 17:49
    */
    Integer insertUser(User user);

    /**
     * Description: 根据用户名查询用户的数据
     * @param username  用户名
     * @return: 返回用户数据,没有找到返回null
     * @Author: liu
     * @Date: 2023/5/7 17:51
    */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改用户密码
     * @param uid 用户的id
     * @param password 用户输入的新密码
     * @param modifiedUser 表示修改的执行者
     * @param modifiedTime 表示修改数据的时间
     * @return 返回值为受影响的行数
     * @Author: liu
     * @Date: 2023/5/9 21:56
    */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);

    /**
     * 根据用户的id查询用户的数据
     * @param uid 用户的id
     * @return 如果找到则返回对象,反之返回null值
     * @Author: liu
     * @Date: 2023/5/9 21:57
    */
    User findByUid(Integer uid);

    /**
     * 参数为user的方法
     * @param user 用户的数据
     * @return 返回值为受影响的行数
     * @Author: liu
     * @Date: 2023/5/10 14:14
    */
    Integer updateInfoByUid(User user);
    
    /** 
     * 根据用户uid修改用户的头像
     * @param id 
     * @param avatar 
     * @param modifiedUser 
     * @param modifiedTime 
     * @return: java.lang.Integer
     * @Author: liu
     * @Date: 2023/5/10 16:37
    */
    Integer updateAvatarByUid(@Param("uid") Integer id,
                              String avatar,
                              String modifiedUser,
                              Date modifiedTime);
}
