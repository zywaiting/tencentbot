package xin.zhuyao.tencentbot.mapper;

import org.apache.ibatis.annotations.Mapper;
import xin.zhuyao.tencentbot.pojo.AppletConfig;

@Mapper
public interface AppletConfigMapper {

    AppletConfig findByExpress(String express);

    Integer updateBootByExpress(String boot, String express);
}
