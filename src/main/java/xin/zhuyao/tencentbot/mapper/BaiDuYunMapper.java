package xin.zhuyao.tencentbot.mapper;

import org.apache.ibatis.annotations.Mapper;
import xin.zhuyao.tencentbot.pojo.BaiDuYunEntity;

import java.util.List;

/**
 * @ClassName BaiDuYunMapper
 * @Description: TODO
 * author zy
 * @date 2019/3/19 21:30
 **/
@Mapper
public interface BaiDuYunMapper {

    List<BaiDuYunEntity> findByfileNameLike(String fileName);
}
