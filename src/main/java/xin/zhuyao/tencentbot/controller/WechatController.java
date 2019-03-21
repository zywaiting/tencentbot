package xin.zhuyao.tencentbot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.httputil.Utils;
import xin.zhuyao.tencentbot.pojo.BaiDuYunEntity;
import xin.zhuyao.tencentbot.pojo.WechatSubscriptionEntity;
import xin.zhuyao.tencentbot.service.WechatService;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/20 17:48
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = "/wechat", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "微信Api", description = "微信Api")
public class WechatController {

    @Autowired
    private WechatService wechatService;

    @RequestMapping(value = "/subscription")
    @ApiOperation(value = "微信订阅号收集资料", notes = "微信订阅号收集资料")
    @ApiImplicitParam(name = "wechatSubscriptionEntityList",value = "wechatSubscriptionEntityList")
    public String tencentPicture(@RequestParam("wechatSubscriptionEntityList") String wechatSubscriptionEntityList) {
        List<WechatSubscriptionEntity> wechatSubscriptionEntities = Arrays.asList(Utils.json(wechatSubscriptionEntityList, WechatSubscriptionEntity[].class));
        wechatService.saveAll(wechatSubscriptionEntities);
        return "ok";
    }
}
