package com.itrip.controller;

import com.itrip.dto.Dto;
import com.itrip.pojo.User;
import com.itrip.common.DtoUtil;
import com.itrip.common.Page;
import com.itrip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class BizController {

    @Resource
    UserService userService;


    @RequestMapping("/display")
    @ResponseBody
    public Dto display(
            @RequestParam(value = "page", defaultValue = "1") int pageIndex,
            @RequestParam(value = "userName", required = false) String userName
    ) {
        Page<User> pageUsers = userService.getPagedUsers(pageIndex,userName);
        return DtoUtil.returnDataSuccess(pageUsers);
    }
}
