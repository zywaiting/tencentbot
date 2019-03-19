package xin.zhuyao.tencentbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import xin.zhuyao.tencentbot.pojo.BaiDuYunEntity;


import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/19 15:45
 * @Version 1.0
 * @Description
 */
public interface BaiDuYunRepository extends JpaRepository<BaiDuYunEntity, Integer>, JpaSpecificationExecutor<BaiDuYunEntity> {
    List<BaiDuYunEntity> findByfileNameLike(String fileName);
}
