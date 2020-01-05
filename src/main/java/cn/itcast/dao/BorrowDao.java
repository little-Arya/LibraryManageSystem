package cn.itcast.dao;


import cn.itcast.domain.Borrow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowDao {

    //查询所有账户
    @Select("select * from tb_borrow")
    public List<Borrow> findAllBorrow();
    //保存账户信息
    @Insert("insert into tb_borrow(BorrowID,rdID,bkID,ldContinueTimes,ldDateOut,ldDateRetPlan,ldDateRetAct,ldOverDay,ldOverMoney,ldPunishMoney,lsHasReturn,OperatorLend,OperatorRet) " +
            "values(#{BorrowID},#{rdID},#{bkID},#{ldContinueTimes},#{ldDateOut},#{ldDateRetPlan},#{ldDateRetAct},#{ldOverDay},#{ldOverMoney},#{ldPunishMoney},#{lsHasReturn},#{OperatorLend},#{OperatorRet})")
    public void saveBorrow(Borrow borrow);

    //根据id查询数据
    @Select("select * from tb_borrow where BorrowID=#{BorrowID}")
    Borrow getBorrowById(int BorrowID);

    // 根据参数更新数据
    //更新
    @Update("update tb_borrow set rdID=#{rdID},bkID=#{bkID},ldContinueTimes=#{ldContinueTimes},ldDateOut=#{ldDateOut},ldDateRetPlan=#{ldDateRetPlan},ldDateRetAct=#{ldDateRetAct},ldOverDay=#{ldOverDay},ldOverMoney=#{ldOverMoney},ldPunishMoney=#{ldPunishMoney},lsHasReturn=#{lsHasReturn},OperatorLend=#{OperatorLend},OperatorRet=#{OperatorRet} where BorrowID=#{BorrowID}")
    public void updateBorrow(Borrow borrow);
}
