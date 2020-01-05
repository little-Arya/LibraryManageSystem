package cn.itcast.service;

import cn.itcast.domain.Borrow;

import java.util.List;

public interface BorrowService {

    //查询所有账户
    public List<Borrow> findAllBorrow();
    //保存账户信息
    public void saveBorrow(Borrow borrow);

    //根据id查询数据
    Borrow getBorrowById(int BorrowID);

    // 根据参数更新数据
    public void updateBorrow(Borrow borrow);
}
