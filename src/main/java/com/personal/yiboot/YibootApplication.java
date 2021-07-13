package com.personal.yiboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.personal.yiboot.dao")
public class YibootApplication {

	public static void main(String[] args) {
		SpringApplication.run(YibootApplication.class, args);
	}

}
