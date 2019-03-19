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
import xin.zhuyao.tencentbot.entitydto.BaiDuYunDto;
import xin.zhuyao.tencentbot.service.BaiDuYunService;

import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/19 16:59
 * @Version 1.0
 * @Description
 */
@Slf4j
@RestController
@RequestMapping(value = "/baiduyun", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "百度云Api", description = "百度云Api")
public class BaiDuYunController {

    @Autowired
    private BaiDuYunService baiDuYunService;

    @RequestMapping(value = "/imgUrl")
    @ApiOperation(value = "百度云地址", notes = "百度云地址")
    @ApiImplicitParam(name = "question",value = "question")
    public List<BaiDuYunDto> tencentBot(@RequestParam("question")  String question){
        return baiDuYunService.findByfileNameLike(question);
    }
}
