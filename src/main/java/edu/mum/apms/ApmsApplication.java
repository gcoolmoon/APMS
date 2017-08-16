package edu.mum.apms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
//@ComponentScan("edu.mum.apms") 
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
