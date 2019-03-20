package xin.zhuyao.tencentbot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xin.zhuyao.tencentbot.entitydto.TencentPictureDto;
import xin.zhuyao.tencentbot.pojo.AppletConfig;
import xin.zhuyao.tencentbot.entitydto.TencentBotDto;
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
            @ApiImplicitParam(name = "session",value = "session"),
            @ApiImplicitParam(name = "question",value = "question")
    })
    public TencentBotDto tencentBot(@RequestParam("session") String session,@RequestParam("question")  String question){
        AppletConfig tencent = appletConfigService.findByExpress("tencent");
        TencentBotDto tencentBotDto = null;
        try {
            tencentBotDto = TencentBotUtils.tencentBot(tencent.getAppId(),tencent.getApiKey(),session, question);
        } catch (Exception e) {
            try {
                tencentBotDto = TencentBotUtils.tencentBot(tencent.getAppId(),tencent.getApiKey(),session, question);
            } catch (Exception e1) {
                try {
                    tencentBotDto = TencentBotUtils.tencentBot(tencent.getAppId(),tencent.getApiKey(),session, question);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return tencentBotDto;
    }

    @RequestMapping(value = "/picture")
    @ApiOperation(value = "腾讯图片处理", notes = "腾讯图片处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imageUrl",value = "imageUrl"),
            @ApiImplicitParam(name = "decoration",value = "decoration")
    })
    public TencentPictureDto tencentPicture(String imageUrl, String decoration) {
        TencentPictureDto tencentPictureDto = TencentPictureUtils.tencentPicture(imageUrl, decoration);
        return tencentPictureDto;
    }

}
