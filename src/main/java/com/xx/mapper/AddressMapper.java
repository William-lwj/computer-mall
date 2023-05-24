package com.xx.mapper;

import com.xx.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Description: 收货地址持久层的接口
 * @ClassName: AddressMapper
 * @Package: com.xx.mapper
 * @Author: liu
 * @Date: 2023/5/11 22:02
 * @Version: 1.0
 */

public interface AddressMapper {

    /**
     * 插入用户的收货地址数据
     * @param address 收货地址数据
     * @return 受影响的行数
     * @Author: liu
     * @Date: 2023/5/11 22:04
     */
    Integer insert(Address address);

    /**
     * 根据用户的uid统计收货地址数量
     * @param uid 用户的uid
     * @return 当前用户的收货地址总数
     * @Author: liu
     * @Date: 2023/5/11 22:05
     */
    Integer countByUid(Integer uid);

    /**
     * 根据用户的uid查询用户的收货地址数据
     * @param uid 用户uid
     * @return 收货地址数据
     * @Author: liu
     * @Date: 2023/5/22 13:34
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询收货地址数据
     * @param aid 收货地址id
     * @return: 收货地址数据
     * @Author: liu
     * @Date: 2023/5/22 23:08
     */
    Address findByAid(Integer aid);

    /**
     * 根据用户的uid来修改用户的收货地址设置为非默认
     * @param uid 用户的id
     * @return: 受影响的行数
     * @Author: liu
     * @Date: 2023/5/22 23:10
     */
    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(@Param("aid") Integer aid,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据收货地址id删除收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的行数
     * @Author: liu
     * @Date: 2023/5/23 23:17
    */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid查询用户最后一次被修改的收货地址数据
     * @param uid 用户id
     * @return 收货地址数据
     * @Author: liu
     * @Date: 2023/5/23 23:17
    */
    Address findLastModified(Integer uid);

}
