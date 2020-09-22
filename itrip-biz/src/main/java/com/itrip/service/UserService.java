package com.itrip.service;

import com.itrip.pojo.User;
import com.itrip.common.Page;

/**
 * 用户的业务逻辑接口
 */
public interface UserService {
    /**
     * 分页查询用户
     *
     * @param pageIndex
     * @param userName
     * @return
     */
    Page<User> getPagedUsers(int pageIndex, String userName);
}
