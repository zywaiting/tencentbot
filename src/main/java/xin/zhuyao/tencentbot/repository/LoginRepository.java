package xin.zhuyao.tencentbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.tencentbot.pojo.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer>, JpaSpecificationExecutor<LoginEntity> {
}
