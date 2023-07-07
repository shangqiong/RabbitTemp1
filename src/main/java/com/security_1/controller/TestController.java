package com.security_1.controller;

import com.security_1.dao.User;
import com.security_1.respons.ResponsResult;
import com.security_1.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private LoginService loginService;


    @GetMapping("/hello")
    public String add(){
        System.out.println("hello");
        return "hello security";
    }

    @GetMapping("/login")
    @PreAuthorize("hasAnyAuthority('login')")
    public String add1(){
        System.out.println("login");
        return "hello login";
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('search')")
    public String add11(){
        System.out.println("search");
        return "hellotest1 search";
    }

    @GetMapping("/add")
    @PreAuthorize("@ex.hasAuthority('add')")
    public String addadd(){
        System.out.println("add");
        return "hellotest1 add";
    }
    @GetMapping("/delete")
    @PreAuthorize("hasAnyAuthority('delete')")
    public String adddelete(){
        System.out.println("delete");
        return "hellotest1 delete";
    }
    @GetMapping("/update")
    @PreAuthorize("hasAnyAuthority('update')")
    public String addupdate(){
        System.out.println("update");
        return "hellotest1 update";
    }
    @PostMapping("/user/login")
    public ResponsResult login(@RequestBody User user){
        System.out.println("登录");
        return loginService.login(user);
    }

    @RequestMapping("/user/logout")
    public ResponsResult logout(){
        return loginService.logout();
    }
}
