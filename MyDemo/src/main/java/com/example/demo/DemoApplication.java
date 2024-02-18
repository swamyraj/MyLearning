package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration

public class DemoApplication  implements CommandLineRunner {

	@Autowired
    private ApplicationContext appContext;

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Bean(name="restTemplate")
	 public RestTemplate getPubPostbackRestTemplate(){
		 final int readTimeOut = 60000;
		 final int connectTimeout = 60000;
		 final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
		 new HttpComponentsClientHttpRequestFactory();
		    clientHttpRequestFactory.setConnectTimeout(connectTimeout);
		    clientHttpRequestFactory.setReadTimeout(readTimeOut);
		 return new RestTemplate(clientHttpRequestFactory);

	 }
	
	@Override
    public void run(String... args) {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
           
        }
        method1();
    }
	
	
	@LogExecutionTime
	public static void method1() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
