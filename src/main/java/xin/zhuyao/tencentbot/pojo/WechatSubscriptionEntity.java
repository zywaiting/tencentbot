package xin.zhuyao.tencentbot.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: zy
 * @Date: 2019/3/20 15:46
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_wechat_subscription")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Api(value = "微信公众号", description = "微信公众号")
public class WechatSubscriptionEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID", dataType = "Integer")
    Integer id;

    @ApiModelProperty(value = "文件名", dataType = "String")
    String fileName;

    @ApiModelProperty(value = "文件地址路径", dataType = "String")
    String fileNameUrl;

    @ApiModelProperty(value = "发送时间", dataType = "String")
    String sendDate;

    @ApiModelProperty(value = "创建时间", dataType = "String")
    String createDate;

    @ApiModelProperty(value = "修改时间", dataType = "String")
    String updateDate;

    @ApiModelProperty(value = "订阅号名称", dataType = "String")
    String subscriptionName;

    @ApiModelProperty(value = "是否被使用过", dataType = "Boolean")
    Boolean employ;
}
