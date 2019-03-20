package xin.zhuyao.tencentbot.service;

import xin.zhuyao.tencentbot.pojo.WechatSubscriptionEntity;

import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/20 17:52
 * @Version 1.0
 * @Description
 */
public interface WechatService {

    List<WechatSubscriptionEntity> saveAll(List<WechatSubscriptionEntity> wechatSubscriptionEntityList);
}
