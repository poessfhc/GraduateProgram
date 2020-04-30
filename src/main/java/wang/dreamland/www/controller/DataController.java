package wang.dreamland.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wang.dreamland.www.dao.DataMapper;
import wang.dreamland.www.entity.Data;
import wang.dreamland.www.entity.User;
import wang.dreamland.www.service.DataService;
import wang.dreamland.www.service.UserService;
import wang.dreamland.www.utils.Result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 输入数据的后端操作
 */
@Controller
public class DataController {
    @Autowired
    private DataService dataService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/doDataInsert",method = RequestMethod.POST)
    @ResponseBody

    public String doDataInsert(@RequestParam(value = "target",required = false) String[] array,
                               @RequestParam(value = "user",required = false) String email
                               ){
//


        int length = array.length/5;

        for(int j = 0;j < length*5;j = j + 5 ){

                String machineName = array[j];
                int current = Integer.parseInt(array[1+j]);
                int voltage = Integer.parseInt((array[2+j]));
                int currentGround = Integer.parseInt(array[3+j]);
                String time = array[4+j];

            /**
             * 其中由于time是Date格式的 所以要把输入的字符串time转成Date格式
             */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try{
                Date currentDate = sdf.parse(time);
                Data data = new Data();
                data.setMachineName(machineName);
                data.setCurrent(current);
                data.setVoltage(voltage);
                data.setCurrentGround(currentGround);
                data.setTime(currentDate);
                data.setName(email);
                dataService.insert(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }






        /*
            插入数据库
         */



        }


        return "{}";

    }

    /**
     * userSet页面的修改name
     */
    @RequestMapping(value = "/doRevise1")
    @ResponseBody
    public Result doRevise1(@RequestParam(value = "newName",required = false) String name,
                           @RequestParam(value = "email",required = false) String email){
        //目前发现的错误是 必须登录后 才能修改信息 靠自动登录的信息是不可以的  同时一次不能改两条 说明必须通过拿刚刚登录的数据才行
        Result result;
        User user = userService.findByEmail(email);
        if(user != null){
            user.setName(name);
            userService.update(user);
            result = new Result(1,"成功");
            return result;
        }
        result = new Result(0,"失败");
        return result;
    }


    /**
     *
     * 改email
     */
    @RequestMapping(value = "/doRevise2")
    @ResponseBody
    public Result doRevise2(@RequestParam(value = "oldEmail",required = false) String oldEmail,
                           @RequestParam(value = "newEmail",required = false) String newEmail){
        Result result;
        User user = userService.findByEmail(oldEmail);
        if(user != null){
            user.setEmail(newEmail);
            userService.update(user);
            result = new Result(1,"成功");
            return result;
        }
        result = new Result(0,"邮箱已存在！");
        return result;
    }

    /**
     * 改密码
     */
    @RequestMapping(value = "/doRevise3")
    @ResponseBody
    public Result doRevise3(@RequestParam(value = "newPsd",required = false) String newPsd,
                            @RequestParam(value = "email",required = false) String email){
        Result result;
        User user = userService.findByEmail(email);
        if(user != null){
            user.setPassword(newPsd);
            userService.update(user);
            result = new Result(1,"成功");
            return result;
        }
        result = new Result(0,"失败");
        return result;
    }

    /**
     * 改户主
     */
    @RequestMapping(value = "/doRevise4")
    @ResponseBody
    public Result doRevise4(@RequestParam(value = "user",required = false) String email
                            ){
        Result result;
        User user = userService.findByEmail(email);
        if(user != null){
            user.setHost("yes");
            userService.update(user);
            result = new Result(1,"成功");
            return result;
        }
        result = new Result(0,"失败");
        return result;
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/doDelete")
    @ResponseBody
    public Result doDelete(@RequestParam(value = "user",required = false) String email
    ){
        Result result;
        User user = userService.findByEmail(email);

            userService.delete(user);
            result = new Result(1,"成功删除");

//        result = new Result(0,"失败");
        return result;
    }


}
