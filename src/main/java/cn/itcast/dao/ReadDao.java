package cn.itcast.dao;

import cn.itcast.domain.Read;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadDao {

    //判断用户是否登录
    @Select("select * from tb_reader where rdName=#{rdName} and rdPwd=#{rdPwd}")
    Read findWithLoginAndPassword(@Param("rdName")String rdName, @Param("rdPwd")Integer rdPwd);


    //查询所有账户
    @Select("select * from tb_reader")
    public List<Read> findAllRead();
    //保存账户信息
    @Insert("insert into tb_reader(rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,rdStatus,rdBorrowQty,rdPwd,rdAdminRoles) " +
            "values(#{rdName},#{rdSex},#{rdType},#{rdDept},#{rdPhone},#{rdEmail},#{rdDateReg},#{rdPhoto},#{rdStatus},#{rdBorrowQty},#{rdPwd},#{rdAdminRoles})")
    public void saveRead(Read read);

    //模糊查找
    @Select("select * from tb_reader where rdType like '%${rdType}%' and rdDept like '%${rdDept}%' and rdName like '%${rdName}%'")
    List<Read> getItemByTDN(Read read);

    /**删除指定id数据*/
    @Delete("delete from tb_reader where rdID=#{rdID}")
    public void deleteReadById(int rdID);

    //根据id查询数据
    //更新前的查询
    @Select("select * from tb_reader where rdID=#{rdID}")
    Read getReadById(int rdID);

    // 根据参数更新数据
    @Update("update tb_reader set rdName=#{rdName},rdSex=#{rdSex},rdType=#{rdType},rdDept=#{rdDept},rdPhone=#{rdPhone},rdEmail=#{rdEmail},rdDateReg=#{rdDateReg},rdPhoto=#{rdPhoto},rdStatus=#{rdStatus},rdBorrowQty=#{rdBorrowQty},rdPwd=#{rdPwd},rdAdminRoles=#{rdAdminRoles} where rdID=#{rdID}")
    public void updateReadById(Read read);

    //根据用户名查询数据
    @Select("select * from tb_reader where rdName=#{rdName}")
    Read getReadByName(String rdName);

    // 根据想让借书数量加一
    @Update("update tb_reader set rdName=#{rdName},rdSex=#{rdSex},rdType=#{rdType},rdDept=#{rdDept},rdPhone=#{rdPhone},rdEmail=#{rdEmail},rdDateReg=#{rdDateReg},rdPhoto=#{rdPhoto},rdStatus=#{rdStatus},rdBorrowQty=#{rdBorrowQty},rdPwd=#{rdPwd},rdAdminRoles=#{rdAdminRoles} where rdID=#{rdID}")
    public void addBroQty(Read read);
}
