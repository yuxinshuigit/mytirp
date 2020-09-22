package com.itrip.service.impl;

import com.itrip.pojo.User;
import com.itrip.common.Page;
import com.itrip.dao.UserMapper;
import com.itrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public Page<User> getPagedUsers(int pageIndex,String userName) {
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        params.put("from",(pageIndex-1)*5);
        params.put("limit",5);
        List<User> users = userMapper.getUsersByParams(params);
        int totalCount = userMapper.getUsersCountByParams(params);
        Page<User> pageUsers = new Page<>(pageIndex,5,totalCount,users);
        return pageUsers;
    }
}
