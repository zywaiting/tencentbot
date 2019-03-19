package xin.zhuyao.tencentbot.repository.spec;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import xin.zhuyao.tencentbot.pojo.BaiDuYunEntity;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BaiDuYunSpec
 * @Description: TODO
 * author zy
 * @date 2019/3/19 21:23
 **/
public interface BaiDuYunSpec {
    static Specification<BaiDuYunEntity> spec(String fileName) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (fileName != null && StringUtils.hasText(fileName)) {
                predicates.add(cb.like(root.get("fileName"), fileName));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
