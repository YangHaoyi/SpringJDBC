package com.yanghaoyi.jdbc.jdbc.dao.impl;

import com.yanghaoyi.jdbc.jdbc.dao.UserDao;
import com.yanghaoyi.jdbc.jdbc.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : YangHaoYi on 2020/5/14.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/5/14.
 * Version : V 1.0
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jt;

    /** 插入用户数据 */
    @Override
    public void insert(UserEntity user) {
        String sql = "insert into user values(0,?,?,?,?,?,?,?)";
        jt.update(sql, user.getUserName(), user.getPassword(),user.getName(),user.getIdNumber(),user.getDepartment(),
                user.getPosition(),user.getMaster());
    }

    /** 删除用户数据 */
    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        jt.update(sql, id);
    }

    /** 修改用户数据 */
    @Override
    public void update(UserEntity user) {
        String sql = "update user set name = ? where id = ?";
        jt.update(sql, user.getUserName(), user.getId());
    }

    /** 查询用户数据 */
    @Override
    public UserEntity getById(int id) {
        String sql = "select * from user where id = ?";
        return jt.queryForObject(sql, new RowMapper<UserEntity>() {
            //查询有返回值才会进入该内部类
            @Override
            public UserEntity mapRow(ResultSet rs, int arg1) throws SQLException {
                UserEntity user = new UserEntity();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("userName"));
                return user;
            }
        }, id);
    }
}
