package xin.zhuyao.tencentbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zhuyao.tencentbot.entitydto.BaiDuYunDto;
import xin.zhuyao.tencentbot.repository.BaiDuYunRepository;
import xin.zhuyao.tencentbot.service.BaiDuYunService;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zy
 * @Date: 2019/3/19 15:36
 * @Version 1.0
 * @Description
 */
@Service
public class BaiDuYunServiceImpl implements BaiDuYunService {

    @Autowired
    private BaiDuYunRepository baiDuYunRepository;


    @Override
    public List<BaiDuYunDto> findByfileNameLike(String fileName) {
        return baiDuYunRepository.findByfileNameLike(fileName).stream().map(BaiDuYunDto::new).collect(Collectors.toList());
    }
}
