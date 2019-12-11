package com.duteliang.webbase;

import com.duteliang.webbase.listener.MyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: zl
 * @Date: 2019/12/10 00:40
 */
@SpringBootApplication
public class WebBaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(WebBaseApplication.class, args);
		run.publishEvent(new MyEvent(new Object()));
	}

}
