package wang.dreamland.www.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;
import wang.dreamland.www.dao.AdminMapper;
import wang.dreamland.www.dao.IdeaMapper;
import wang.dreamland.www.entity.Admin;
import wang.dreamland.www.entity.Idea;
import wang.dreamland.www.entity.User;
import wang.dreamland.www.service.UserService;
import wang.dreamland.www.utils.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册的controller层操作
 */
//@RequestMapping("/user")
@Controller
public class RegisterController {
    private final static Logger log = Logger.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private IdeaMapper ideaMapper;
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员注册
     */
    @RequestMapping("/adminDoRegister")
    @ResponseBody
    public Result adminDoRegister(@RequestParam(value = "adminEmail") String user, @RequestParam(value = "psd") String pwd) {
        Result result;
        Admin adminInfo = new Admin();
        adminInfo.setUser(user);
        Admin admin = adminMapper.selectOne(adminInfo);
        if (admin != null){
            Example example = new Example(Admin.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("user",user);
            admin = new Admin(user,pwd);
            adminMapper.updateByExampleSelective(admin,example);
            result = new Result(1,"修改成功");
            return result;
        }
        adminMapper.insert(new Admin(user, pwd));
        result = new Result(1,"注册成功");
        return result;
    }

    /**
     * 注册
     *
     * @param email
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/doRegister")
    @ResponseBody
    public Result doRegister(@RequestParam(value = "user", required = false) String email,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "psd", required = false) String password) {
        int num = 0;
        Result result;
        User user = userService.findByEmail(email);
        if (user != null) {
            result = new Result(0, "用户名存在");
            return result;
        }
        num = 1;
        user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setImg("covers/default.jpg");

        userService.regist(user);
        result = new Result(200, "注册成功");
        return result;
    }

    /**
     * 用于测试
     *
     * @param id
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> doIdea(@RequestParam(value = "id", required = false) int id) {
        Map map = new HashMap<String, Object>();
        Idea idea = new Idea();
        idea.setId(id);
        ideaMapper.insert(idea);
        map.put("message", id);
        return map;
    }


}
