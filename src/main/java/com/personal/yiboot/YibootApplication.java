package com.personal.yiboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.personal.yiboot.dao")
@EnableSwagger2
@EnableAsync
@ImportResource(value = {"classpath:spring/spring-dubbo.xml"})
public class YibootApplication {

	public static void main(String[] args) {
		SpringApplication.run(YibootApplication.class, args);
	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(YibootApplication.class);
//	}
}
