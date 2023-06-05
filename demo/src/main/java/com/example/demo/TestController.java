package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/demo/test")
public class TestController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/resttemplate")
	public  void test(){
		System.out.println(restTemplate);
	}
}
