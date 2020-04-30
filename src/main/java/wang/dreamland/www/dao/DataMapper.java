package wang.dreamland.www.dao;

import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.mapper.common.Mapper;
import wang.dreamland.www.entity.Data;

import java.util.Date;
import java.util.List;

//@MapperScan
public interface DataMapper extends Mapper<Data> {
    public Data selectByName(Data data);
    public List<Data> selectByNameAndMachineName(Data data);
    public List<Data> selectTime(Data data);
    public List<Data> selectTimeCompare(Data data);

}
