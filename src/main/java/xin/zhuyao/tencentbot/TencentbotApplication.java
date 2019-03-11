package xin.zhuyao.tencentbot;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@SpringBootApplication
public class TencentbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TencentbotApplication.class, args);
    }

}
