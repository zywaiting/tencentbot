package xin.zhuyao.tencentbot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/1/3 10:24
 * @Version 1.0
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "xin.zhuyao.tencentbot";
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /**api接口包扫描路径*/
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                /**可以根据url路径设置哪些请求加入文档，忽略哪些请求*/
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                /**设置文档的标题*/
                .title("接口文档")
                /**设置文档的描述*/
                .description("IESP接口文档")
                /**设置文档的联系方式*/
                .contact(new Contact("zy","http://www.baidu.com","1573240324@qq.com"))
                /**设置文档的License信息->1.3 License information*/
                .termsOfServiceUrl("www.abc.com")
                .license("xxx")
                .licenseUrl("http://www.xxx.com")
                /**设置文档的版本信息-> 1.1 Version information*/
                .version(VERSION)
                .build();
    }

}
