package com.personal.yiboot.config;

import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class Swagger2 {
    // swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*"))).paths(Predicates.not(PathSelectors.regex("/info.*")))
                .paths(Predicates.not(PathSelectors.regex("/autoconfig.*")))
                .paths(Predicates.not(PathSelectors.regex("/health.*")))
                .paths(Predicates.not(PathSelectors.regex("/metrics.*")))
                .paths(Predicates.not(PathSelectors.regex("/mappings.*")))
                .paths(Predicates.not(PathSelectors.regex("/trace.*")))
                .paths(Predicates.not(PathSelectors.regex("/configprops.*")))
                .paths(Predicates.not(PathSelectors.regex("/beans.*"))).paths(Predicates.not(PathSelectors.regex("/env.*")))
                .paths(Predicates.not(PathSelectors.regex("/dump.*")))
                .paths(Predicates.not(PathSelectors.regex("/auditevents.*")))
                .paths(Predicates.not(PathSelectors.regex("/docs.*"))).paths(Predicates.not(PathSelectors.regex("/archaius.*")))
                .paths(Predicates.not(PathSelectors.regex("/features.*")))
                .paths(Predicates.not(PathSelectors.regex("/pause.*"))).paths(Predicates.not(PathSelectors.regex("/refresh.*")))
                .paths(Predicates.not(PathSelectors.regex("/resume.*")))
                .paths(Predicates.not(PathSelectors.regex("/actuator.*")))
                .paths(Predicates.not(PathSelectors.regex("/jolokia.*")))
                .paths(Predicates.not(PathSelectors.regex("/loggers.*")))
                .paths(Predicates.not(PathSelectors.regex("/restart.*")))
                .paths(Predicates.not(PathSelectors.regex("/service-registry/instance-status.*")))
                .paths(Predicates.not(PathSelectors.regex("/logfile.*")))
                .paths(Predicates.not(PathSelectors.regex("/channels.*"))).paths(Predicates.not(PathSelectors.regex("/bus.*")))
                .paths(Predicates.not(PathSelectors.regex("/heapdump.*"))).build();
    }
    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("SpringBoot 本地项目yiboot Swagger2 构建RESTful API")
                // 创建人信息
                .contact(new Contact("mjgogogo",  "https://www.cnblogs.com/zs-notes/category/1258467.html",  "chenmengjiao126@126.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("API 描述")
                .build();
    }
}