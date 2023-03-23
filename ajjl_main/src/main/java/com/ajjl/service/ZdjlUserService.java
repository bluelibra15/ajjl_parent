package com.ajjl.service;

import com.ajjl.pojo.ZdjlUser;

import java.text.ParseException;
import java.util.List;

public interface ZdjlUserService {
    String bind(ZdjlUser zdjlUser);

    String heart(String userId) throws ParseException;

    List<ZdjlUser> getZdjlUser(ZdjlUser zdjlUser);

    int addZdjlUser(ZdjlUser zdjlUser);

    void updateZdjlUserByRegCode();

}
