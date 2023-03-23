package com.ajjl.service.imp;

import com.ajjl.dao.OtherInfoDao;
import com.ajjl.pojo.OtherInfo;
import com.ajjl.service.OtherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OtherInfoServiceImpl implements OtherInfoService {
    @Autowired
    OtherInfoDao otherInfoDao;

    @Override
    public int add(OtherInfo otherInfo) {
        return otherInfoDao.insert(otherInfo);
    }

    @Override
    public OtherInfo find(OtherInfo otherInfo) {
        return otherInfoDao.selectOne(otherInfo);
    }

    @Override
    public int del(OtherInfo otherInfo) {
        return otherInfoDao.delete(otherInfo);
    }
}
