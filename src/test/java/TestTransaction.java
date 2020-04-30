import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import wang.dreamland.www.entity.Data;
import wang.dreamland.www.entity.User;
import wang.dreamland.www.service.DataService;
import wang.dreamland.www.service.IdeaService;
import wang.dreamland.www.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 12903 on 2018/5/30.
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestTransaction extends AbstractJUnit4SpringContextTests {
    @Autowired
    private UserService userService;
    private IdeaService ideaService;
    @Autowired
    private DataService dataService;


    @Test
    public void testSave(){
        //注册
//        User user = new User();
//        user.setName("lihaoqi");
//        user.setEmail("869156715@1233.com");
//        user.setPassword("123456");
//        user.setHoster("yes");
//        userService.regist(user);

        /**
         * 根据id查找内容
         */

//       User user = userService.findById(18);
//       System.out.println(user.getName());

        /**
         * 根据Email查找内容  必须加入id
         */
//
//        String email = "869156715";
//        User user = userService.findByEmail(email);
//        System.out.println(user.getPassword());


//        Idea idea = ideaService.findById(3);
//        System.out.println(idea.getName());

        /**
         * 登录
         */
//        User user = userService.login("8691","lih");
//        System.out.println(user.getName());
        /**
         * 测试更新
         */
//        User user = userService.findByEmail("869156715");
//        user.setPassword("999");
//        userService.updateByEmail(user);
        User user = userService.findByEmail("lihaoqi");
        user.setName("shimingwei");
//        userService.updateByEmail(user);
          userService.update(user);
        /**
         * 测试电流数据插入
         */
//        Data data = new Data();
//        data.setVoltage(456);
//        data.setMachineName("b");
//        data.setCurrentGround(321);
//        data.setCurrent(78);
//        data.setTime("1997-11-14 22:45");
//        data.setName("李浩奇");
//
//        dataService.insert(data);
        /**
         * 测试根据姓名找到用电器相关内容
         */

//        Data data = dataService.findByName("lihaoqi");
//        System.out.println(data.getCurrent());
//        System.out.println(data.getMachineName());
//        System.out.println(data.getTime());
        /**
         * 根据姓名和用电器名找到所有信息
         */
//        Data data = new Data();
//        List<Data> list = dataService.findByNameAndMachineName("lihaoqi","收音机");
//        for (Data da:list
//             ) {
//            System.out.println(da.getCurrent()+" "+da.getCurrentGround()+" "+da.getVoltage()+" "+da.getTime());
//
//        }
//
//        Date date = new Date();
//       SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//       String s1 = s.toString();
//
//        System.out.println(s1);
        /**
         * 加入时间
         */
//       Date currentDate = new Date();
//       Calendar  calendar = Calendar.getInstance();
//       calendar.setTime(currentDate);
//       calendar.add(Calendar.DAY_OF_MONTH,-1);

//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
////       String starDate = sdf.format(calendar.getTime());2019-11-02 22:45
//            String s = "2019-11-02 22:45";
//            Date date = sdf.parse(s);
//
//            Data data = new Data();
//            data.setTime(date);
//            dataService.insert(data);
//
//        }catch (ParseException e) {
//            e.printStackTrace();
//        }

        /**
         * 比较时间
         */
//        List<Data> list = dataService.findByTime("2019-11-02 23:45");
//        for (Data da:list
//             ) {
//            System.out.println(da.getName());
//
//        }  完成



//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        try {
//            Data data = new Data();
//            String time = "2019-11-2 23:45";
//            Date currentDate = new Date();
//            currentDate = sdf.parse(time);
//            data.setTime(currentDate);
//
//
//        List<Data> list = dataService.findByTime(data)
//        for (Data da:
//             ) {
//
//        }
//        }catch (ParseException e) {
//        e.printStackTrace();
//    }
        /**
         * 比较时间
         */
//
//        List<Data> list = dataService.findTimeCompare("2019-12-03 16:43");
//        for (Data da:list
//             ) {
//            System.out.println(da.getName());
//
//        }
        /**
         * 删除用户
         */
        User user1 = userService.findByEmail("jjcas");
        userService.delete(user1);













    }
}
