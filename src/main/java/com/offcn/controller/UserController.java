package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manageruser")
public class UserController {

    @Autowired
    private UserService userService;

    //查询全部用户信息
    @GetMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("page",userList);
        return "user/list";
    }

    //跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(){

        return "user/userAdd";

    }

    //保存新增用户
    @PostMapping("/add")
    public String add(User user){
        userService.createUser(user);
        return "redirect:/manageruser/";
    }

    //跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id") Long id){
        //获取id用户信息
        User user = userService.findOneUser(id);
        //把user传递给前端页面
        model.addAttribute("user",user);
        return "user/userEdit";
    }
    //保存编辑内容
    @PutMapping("/edit")
    public String edit(User user){
        userService.updateUserById(user.getId(),user);
        return "redirect:/manageruser/";
    }

    //删除指定id的用户
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/manageruser/";

    }


}
