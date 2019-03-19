package xin.zhuyao.tencentbot.service;


import xin.zhuyao.tencentbot.entitydto.BaiDuYunDto;

import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/19 15:36
 * @Version 1.0
 * @Description
 */
public interface BaiDuYunService {
    //获取
    List<BaiDuYunDto> findByfileNameLike(String fileName);
}
