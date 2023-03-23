package com.ajjl.service;

import com.ajjl.pojo.OtherInfo;

public interface OtherInfoService {
    int add(OtherInfo otherInfo);

    OtherInfo find(OtherInfo otherInfo);

    int del(OtherInfo otherInfo);
}
