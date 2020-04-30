package wang.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.dreamland.www.dao.DataMapper;
import wang.dreamland.www.entity.Data;
import wang.dreamland.www.service.DataService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public int insert(Data data) {
        return dataMapper.insert(data);


    }

    @Override
    public Data findByName(String email) {
        Data data = new Data();
        data.setName(email);
        return dataMapper.selectByName(data);
    }

    @Override
    public List<Data> findByNameAndMachineName(String email, String machineName) {
        Data data = new Data();
        data.setName(email);
        data.setMachineName(machineName);
        return dataMapper.selectByNameAndMachineName(data);
    }

    @Override
    public List<Data> findByTime(String time) {
        Data data = new Data();
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date currentDate  = sdf.parse(time);
            data.setTime(currentDate);

        }catch (ParseException e) {
            e.printStackTrace();
        }

        return dataMapper.selectTime(data);


    }

    @Override
    public List<Data> findTimeCompare(String time) {
        Data data = new Data();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date currentDate  = sdf.parse(time);
            data.setTime(currentDate);

        }catch (ParseException e) {
            e.printStackTrace();
        }

        return dataMapper.selectTimeCompare(data);
    }
}
