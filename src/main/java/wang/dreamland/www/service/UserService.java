package wang.dreamland.www.service;

import org.springframework.stereotype.Service;
import wang.dreamland.www.entity.User;

@Service
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    int regist(User user);

    /**
     *
     * 用户登录
     * @param password
     * @return
     */
    User login(String email,String password);//

    User findById(int id);

    User findByEmail(String email);

    void updateByEmail(User user);

    void update(User user);

    int delete(User user);

}
