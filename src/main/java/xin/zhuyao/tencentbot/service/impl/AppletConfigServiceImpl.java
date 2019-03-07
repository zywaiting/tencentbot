package xin.zhuyao.tencentbot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zhuyao.tencentbot.mapper.AppletConfigMapper;
import xin.zhuyao.tencentbot.pojo.AppletConfig;
import xin.zhuyao.tencentbot.service.AppletConfigService;

@Service
public class AppletConfigServiceImpl implements AppletConfigService {

    @Autowired
    private AppletConfigMapper appletConfigMapper;


    @Override
    public AppletConfig findByExpress(String express) {
        return appletConfigMapper.findByExpress(express);
    }

    @Override
    public Integer updateBootByExpress(String boot, String express) {
        return appletConfigMapper.updateBootByExpress(boot,express);
    }
}
