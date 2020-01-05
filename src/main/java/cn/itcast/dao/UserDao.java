package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    //判断用户是否登录
    @Select("select * from user where username=#{username} and password=#{password}")
    User findWithLoginAndPassword(@Param("username")String username, @Param("password")String password);

    //查询所有账户
    @Select("select * from tb_readertype")
    public List<User> findAllUser();

    @Delete("delete from tb_readertype where rdType=#{rdType}")
    public void deleteTYReadById(int rdType);

    //根据用户类型查找数据
    //更新前的查询
    @Select("select * from tb_readertype where rdType=#{rdType}")
    User getRTByType(int rdType);

    //根据参数更新数据
    //更新
    @Update("update tb_readertype set rdTypeName=#{rdTypeName},canendQty=#{canendQty},canendDay=#{canendDay},canContinueTimes=#{canContinueTimes},punishRate=#{punishRate},pateValid=#{pateValid} where rdType=#{rdType}")
    public void updateTYById(User user);

}
