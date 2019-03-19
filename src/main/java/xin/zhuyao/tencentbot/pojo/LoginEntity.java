package xin.zhuyao.tencentbot.pojo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


/**
 * @ClassName LoginEntity
 * @Description: TODO
 * author zy
 * @date 2019/3/19 2:07
 **/
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_login_picture")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String uuid;

    String url;
}
