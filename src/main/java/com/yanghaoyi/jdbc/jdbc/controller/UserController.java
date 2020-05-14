package com.yanghaoyi.jdbc.jdbc.controller;

import com.yanghaoyi.jdbc.jdbc.dao.UserDao;
import com.yanghaoyi.jdbc.jdbc.model.UserEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;
import java.util.Date;

/**
 * @author : YangHaoYi on 2020/5/14.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/5/14.
 * Version : V 1.0
 */
@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @ApiOperation(value = "新增用户", notes = "根据ID插入用户数据", httpMethod = "POST")
    @RequestMapping(value = "/info", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void insertUser(@RequestBody UserEntity userEntity) {
        userDao.insert(userEntity);
    }

    @ApiOperation(value = "删除用户", notes = "根据ID删除用户数据", httpMethod = "DELETE")
    @RequestMapping(value = "/info", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteUser(@RequestParam(value="userId") int userId) {
        userDao.delete(userId);
    }

    @ApiOperation(value = "修改用户", notes = "根据ID修改用户数据", httpMethod = "PUT")
    @RequestMapping(value = "/info", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateUser(@RequestBody UserEntity userEntity) {
        userDao.update(userEntity);
    }

    @ApiOperation(value = "查询用户信息", notes = "根据ID查询用户信息", httpMethod = "GET")
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Object getUserInfo(@RequestParam(value="userId") int userId) {
        return userDao.getById(userId);
    }


}
