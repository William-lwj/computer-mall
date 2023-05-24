package com.xx.controller;

import com.xx.controller.ex.*;
import com.xx.pojo.User;
import com.xx.service.IUserService;
import com.xx.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 用户控制层
 * @ClassName: UserController
 * @Package: com.xx.controller
 * @Author: liu
 * @Date: 2023/5/8 14:41
 * @Version: 1.0
 */
@RestController
@RequestMapping("users")

public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword,
                                           HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {

        Integer uid = getUidFromSession(session);
        userService.changeInfo(uid, user);
        return new JsonResult<>(OK);

    }

    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, MultipartFile file) {

        //判断文件是否为null
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        //判断文件的类型是否是我们规定的后缀类型
        String contentType = file.getContentType();
        //如果集合包含某个元素则返回值为true
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }

        String parent = session.getServletContext().getRealPath("upload");

        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();//创建当前目录
        }

        String originalFilename = file.getOriginalFilename();
        System.out.println("OriginalFilename=" + originalFilename);
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);

        String filename = UUID.randomUUID().toString().toUpperCase() + suffix;

        File dest = new File(dir, filename);

        try {
            //transferTo是一个封装的方法,用来将file文件中的数据写入到dest文件
            file.transferTo(dest);
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/" + filename;
        userService.changeAvatar(uid, avatar, username);
        //返回用户头像的路径给前端页面,将来用于头像展示使用
        return new JsonResult<>(OK, avatar);

    }

}
