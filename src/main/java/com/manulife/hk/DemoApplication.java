package com.manulife.hk;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.TimeZone;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.manulife.*")
public class DemoApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		SpringApplication.run(DemoApplication.class, args);
	}
}
