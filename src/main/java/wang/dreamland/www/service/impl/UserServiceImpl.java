package wang.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import wang.dreamland.www.dao.UserMapper;
import wang.dreamland.www.entity.User;
import wang.dreamland.www.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void update(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("email",user.getEmail());
        userMapper.updateByExampleSelective(user,example);
    }

    @Override
    public int regist(User user) {
        return userMapper.insert(user);

    }

    @Override
    public User login(String email, String password) {
        User user = new User();
        user.setEmail( email );
        user.setPassword( password );
        return userMapper.selectOne( user );

        //return userMapper.findUserByNameAndPwd( name,password );
    }

    @Override
    public User findById(int id) {
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        return userMapper.selectOne(user);
    }

    @Override
    public void updateByEmail(User user) {
        userMapper.updateByPrimaryKey(user);


    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }
}
