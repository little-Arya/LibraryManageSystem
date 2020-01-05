package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {

    //判断用户登录
    User login(String username, String password);

    //查询所有账户
    public List<User> findAllUser();

    //根据用户类型删除
    /**
     * 删除指定id数据
     */
    public void deleteTYReadById(int rdType);

    User getRTByType(int rdType);

    //根据参数更新数据
    public void updateTYById(User user);
}
