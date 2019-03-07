package xin.zhuyao.tencentbot.service;

import xin.zhuyao.tencentbot.pojo.AppletConfig;

public interface AppletConfigService {

    //获取信息
    AppletConfig findByExpress(String express);

    Integer updateBootByExpress(String boot, String express);
}
