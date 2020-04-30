package wang.dreamland.www.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "data")
public class Data {

////    @Column(name = "id")
//    private int id;
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }

    @Column(name = "machineName")
    private String machineName;
    @Column(name = "current")
    private int current;
    @Column(name = "currentGround")
    private int currentGround;
    @Column(name = "voltage")
    private int voltage;
    @Column(name = "time")
//    private String time;
    private Date time;
    @Column(name = "email")
    private String email;

    public String getName() {
        return email;
    }

    public void setName(String email) {
        this.email = email;
    }

    public int getCurrentGround() {
        return currentGround;
    }

    public void setCurrentGround(int currentGround) {
        this.currentGround = currentGround;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }


}
