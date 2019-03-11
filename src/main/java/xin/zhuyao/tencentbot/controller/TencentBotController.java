package xin.zhuyao.tencentbot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.tencentbot.pojo.AppletConfig;
import xin.zhuyao.tencentbot.pojo.TencentBotReturn;
import xin.zhuyao.tencentbot.pojo.TencentPictureReturn;
import xin.zhuyao.tencentbot.service.AppletConfigService;
import xin.zhuyao.tencentbot.utils.TencentBotUtils;
import xin.zhuyao.tencentbot.utils.TencentPictureUtils;

/**
 * @Author: zy
 * @Date: 2019/3/7 15:34
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = "/tencent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "腾讯API", description = "腾讯API")
public class TencentBotController {

    @Autowired
    private AppletConfigService appletConfigService;

    @RequestMapping(value = "/bot")
    @ApiOperation(value = "腾讯机器人", notes = "腾讯机器人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "question",value = "boot"),
            @ApiImplicitParam(name = "session",value = "session"),
            @ApiImplicitParam(name = "question",value = "question")
    })
    public TencentBotReturn tencentBot(String boot,String session, String question) throws Exception {
        TencentBotReturn tencentBotReturn = new TencentBotReturn();
        AppletConfig tencent = appletConfigService.findByExpress("tencent");
        if ("开机".equals(boot)) {
            if (!"1".equals(tencent.getAppSecret())) {
                appletConfigService.updateBootByExpress("1","tencent");
            }
            tencentBotReturn = TencentBotUtils.tencentBot(tencent.getAppId(),tencent.getApiKey(),session, question);
            return tencentBotReturn;
        } else if ("关机".equals(boot)) {
            appletConfigService.updateBootByExpress("0","tencent");
            tencentBotReturn.setMsg("关机");
            return tencentBotReturn;
        } else {
            if ("1".equals(tencent.getAppSecret())) {
                tencentBotReturn = TencentBotUtils.tencentBot(tencent.getAppId(), tencent.getApiKey(), session, question);
                return tencentBotReturn;
            } else {
                tencentBotReturn.setMsg("关机");
                return tencentBotReturn;
            }
        }
    }

    @RequestMapping(value = "/picture")
    @ApiOperation(value = "腾讯图片处理", notes = "腾讯图片处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imageUrl",value = "imageUrl"),
            @ApiImplicitParam(name = "decoration",value = "decoration")
    })
    public TencentPictureReturn tencentPicture(String imageUrl, String decoration) {
        TencentPictureReturn tencentPictureReturn = new TencentPictureReturn();
        AppletConfig tencent = appletConfigService.findByExpress("tencent");
        if ("1".equals(tencent.getAppSecret())) {
            tencentPictureReturn = TencentPictureUtils.tencentPicture(imageUrl, decoration);
        }else {
            tencentPictureReturn.setMsg("关机");
        }
        return tencentPictureReturn;
    }

}
