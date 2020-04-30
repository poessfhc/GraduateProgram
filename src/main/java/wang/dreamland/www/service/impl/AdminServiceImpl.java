package wang.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.dreamland.www.dao.AdminMapper;
import wang.dreamland.www.entity.Admin;
import wang.dreamland.www.service.AdminService;

/**
 * @ClassName: AdminServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/25 13:15
 * @Version: v1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String user, String pwd) {
        Admin admin = new Admin(user,pwd);
        return adminMapper.selectOne(admin);
    }
}
