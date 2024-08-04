package com.klfront.klblog.dataconsumer.controller;

import com.klfront.klblog.dataconsumer.model.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author:lujinlong
 * @created:2024-08-04 12:44
 **/

@RestController
@RequestMapping("/sysUser")
public class UserController {
    @GetMapping(value = "/view")
    @PreAuthorize("hasAuthority('user_view')")//拥有user_view权限方可访问此url
    public String showUser(){
        //这样可以很方便地获取用户身份信息
        UserDto userDTO = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDTO.getUsername()+" 访问用户资源" + System.currentTimeMillis();
    }
}
