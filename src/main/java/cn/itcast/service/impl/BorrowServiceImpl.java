package cn.itcast.service.impl;

import cn.itcast.dao.BorrowDao;
import cn.itcast.domain.Borrow;
import cn.itcast.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowDao borrowDao;

    @Override
    public List<Borrow> findAllBorrow() {
        return borrowDao.findAllBorrow();
    }

    @Override
    public void saveBorrow(Borrow borrow) {
        borrowDao.saveBorrow(borrow);
    }

    @Override
    public Borrow getBorrowById(int BorrowID) {
        return borrowDao.getBorrowById(BorrowID);
    }

    @Override
    public void updateBorrow(Borrow borrow) {
        borrowDao.updateBorrow(borrow);
    }
}
