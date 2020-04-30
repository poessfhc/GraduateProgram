package wang.dreamland.www.service;

import wang.dreamland.www.entity.Admin;

/**
 * @ClassName: AdminService
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/25 13:14
 * @Version: v1.0
 */
public interface AdminService {
    /**
     * 管理员登陆
     */
    Admin login(String user, String pwd);
}
