package wang.dreamland.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wang.dreamland.www.entity.Admin;
import wang.dreamland.www.entity.User;
import wang.dreamland.www.service.AdminService;
import wang.dreamland.www.service.UserService;
import wang.dreamland.www.utils.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/adminDoLogin")
    @ResponseBody
    public Result adminLogin(@RequestParam(value = "adminEmail") String user,@RequestParam(value = "psd") String pwd){
        Result result;
        Admin admin = adminService.login(user,pwd);
        if (admin != null){
            result = new Result(1,"登录成功");
            return result;
        }
        result = new Result(0,"用户名或密码错误");
        return result;
    }


    @RequestMapping("/doLogin")
    @ResponseBody
    public Result doLogin(@RequestParam(value = "user",required = false) String email,
                          @RequestParam(value = "psd",required = false) String password){
//        Integer i = new Integer(1);

        Result result;
        User userData = new User();


        User user = userService.login(email,password);
        //成功验证之后拿到那三个数据
        if(user != null){
            String userName = user.getName();
            String userCover = user.getImg();
            String host = user.getHost();
            userData.setHost(host);
            userData.setName(userName);
            userData.setImg(userCover);
        }else{
            result = new Result(0,"用户名或密码错误");
            return result;
        }
        result = new Result(200,"登录成功");
        result.putData("userData",userData);
        return result;
    }

//    @RequestMapping("/doRevise")
//    @ResponseBody
//    public Integer doRevise(@RequestParam(value = "user",required = false) String email,
//                        @RequestParam(value = "psd",required = false) String password){
//        //返回一个键值对，里面存放status和cover，host，name
//
//        User user = userService.findByEmail(email);
//        user.setPassword(password);
//        userService.updateByEmail(user);
////        user.setImg("../covers/default.jpg");
//      Integer i = new Integer(1);
//
//
//
//
//
//        if(user != null){
//            i = 1;
//
//
//
//        }else {
//            i = 0;
//
//        }
//
//        return i;
//    }




}
