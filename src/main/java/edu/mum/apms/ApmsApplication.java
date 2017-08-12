package edu.mum.apms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("servlet-config.xml")
public class ApmsApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApmsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApmsApplication.class, args);
	}
}
