package com.yanghaoyi.jdbc.jdbc.dao;

import com.yanghaoyi.jdbc.jdbc.model.UserEntity;

/**
 * @author : YangHaoYi on 2020/5/14.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/5/14.
 * Version : V 1.0
 */
public interface UserDao {

    /** 插入用户数据 */
    void insert(UserEntity user);

    /** 删除用户数据 */
    void delete(int id);

    /** 修改用户数据 */
    void update(UserEntity user);

    /** 查询用户数据 */
    UserEntity getById(int id);
}
