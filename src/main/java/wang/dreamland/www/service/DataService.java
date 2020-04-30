package wang.dreamland.www.service;

import org.springframework.stereotype.Service;
import wang.dreamland.www.entity.Data;

import java.util.List;

@Service
public interface DataService {
    /**
     *  插入数据
     */
    int insert(Data data);

    /**
     *
     * 通过姓名找到内容
     * @return
     */
    Data findByName(String email);

    /**
     *
     * 通过姓名和用电器找到相关信息
     */
    List<Data> findByNameAndMachineName(String email,String machineName);
    /**
     * 通过时间找
     */
    List<Data> findByTime(String time);

    /**
     * 通过比较时间找数据
     */
    List<Data> findTimeCompare(String time);


}
