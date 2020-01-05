package cn.itcast.service;

import cn.itcast.domain.Read;

import java.util.List;

public interface ReadService {

    //判断用户登录
    Read login(String rdName, Integer rdPwd);

    //查询所有账户
    public List<Read> findAllRead();
    //保存账户信息
    public void saveRead(Read read);

    //模糊查找
    List<Read> getItemByTDN(Read read);

    /**
     * 删除指定id数据
     */
    public void deleteReadById(int rdID);

    //根据id查询数据
    Read getReadById(int rdID);

    //根据用户名查询数据
    Read getReadByName(String rdName);

   // 根据参数更新数据
    public void updateReadById(Read read);


    // 根据想让借书数量加一
    public void addBroQty(Read read);
}
