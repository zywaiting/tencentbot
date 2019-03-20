package xin.zhuyao.tencentbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.tencentbot.pojo.WechatSubscriptionEntity;




/**
 * @Author: zy
 * @Date: 2019/3/19 15:45
 * @Version 1.0
 * @Description
 */
public interface WechatSubscriptionRepository extends JpaRepository<WechatSubscriptionEntity, Integer>, JpaSpecificationExecutor<WechatSubscriptionEntity> {

}
