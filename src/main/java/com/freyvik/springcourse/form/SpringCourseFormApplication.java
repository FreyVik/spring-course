package com.freyvik.springcourse.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value= "messages.properties")
public class SpringCourseFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseFormApplication.class, args);
	}

}
