package wang.dreamland.www.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName: Admin
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/4/25 13:11
 * @Version: v1.0
 */
@Entity
@Table(name = "Admin")
public class Admin {
    private String user;
    private String psd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public Admin(String user, String psd) {
        this.user = user;
        this.psd = psd;
    }

    public Admin() {
    }
}
