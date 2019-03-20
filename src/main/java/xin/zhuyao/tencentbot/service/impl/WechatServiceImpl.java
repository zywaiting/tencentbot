package xin.zhuyao.tencentbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zhuyao.tencentbot.pojo.WechatSubscriptionEntity;
import xin.zhuyao.tencentbot.repository.WechatSubscriptionRepository;
import xin.zhuyao.tencentbot.service.WechatService;

import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/20 17:52
 * @Version 1.0
 * @Description
 */
@Service
public class WechatServiceImpl implements WechatService {

    @Autowired
    private WechatSubscriptionRepository wechatSubscriptionRepository;

    @Override
    public List<WechatSubscriptionEntity> saveAll(List<WechatSubscriptionEntity> wechatSubscriptionEntityList) {
        return wechatSubscriptionRepository.saveAll(wechatSubscriptionEntityList);
    }
}
