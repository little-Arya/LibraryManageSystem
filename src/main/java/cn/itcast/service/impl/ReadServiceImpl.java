package cn.itcast.service.impl;

import cn.itcast.dao.ReadDao;
import cn.itcast.domain.Read;
import cn.itcast.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("readService")
public class ReadServiceImpl implements ReadService {
    @Autowired
    private ReadDao readDao;

    @Override
    public Read login(String rdName, Integer rdPwd) {
        return readDao.findWithLoginAndPassword(rdName, rdPwd);
    }

    @Override
    public List<Read> findAllRead() {
        return readDao.findAllRead();
    }

    @Override
    public void saveRead(Read read) {
        readDao.saveRead(read);
    }

    @Override
    public List<Read> getItemByTDN(Read read) {
        return readDao.getItemByTDN(read);
    }

    @Override
    public void deleteReadById(int rdID) {
        readDao.deleteReadById(rdID);


    }

    @Override
    public Read getReadById(int rdID) {
        return readDao.getReadById(rdID);
    }

    @Override
    public Read getReadByName(String rdName) {
        return readDao.getReadByName(rdName);
    }

    @Override
    public void updateReadById(Read read) {
        readDao.updateReadById(read);
    }

    @Override
    public void addBroQty(Read read) {
        readDao.addBroQty(read);
    }
}
