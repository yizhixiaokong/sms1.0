package com.briup.app02.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 路由命名空间
 * http://127.0.0.1:8080 访问到当前项目
 * http://127.0.0.1:8080/test 访问到当前项目的TestController类
 * http://127.0.0.1:8080/test/hello 访问到当前项目的TestController类中的hello方法
 * 		
 * */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("hello")
	public String hello(){
		return "hahahahah";
	}
}
