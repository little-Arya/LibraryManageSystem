package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User login(String username, String password) {
        return userDao.findWithLoginAndPassword(username,password);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void deleteTYReadById(int rdType) {
        userDao.deleteTYReadById(rdType);
    }

    @Override
    public User getRTByType(int rdType) {
        return userDao.getRTByType(rdType);
    }

    @Override
    public void updateTYById(User user) {
        userDao.updateTYById(user);
    }
}
