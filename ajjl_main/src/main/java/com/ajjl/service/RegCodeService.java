package com.ajjl.service;

import com.ajjl.pojo.RegCode;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RegCodeService {
    void test();

    PageInfo<RegCode> findAll(Integer currentPage, Integer pageSize);

    List<RegCode> addRegCode(Integer num,String appName,String type,Integer time,Integer multiWindow);
}
