package com.example.demo.TestAop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Test {
	
	@MyAnnotation
	private TestAnnotation test;
	
	@PostMapping("/aop")
	@MyAnnotation(id = 3)
	public String testAop() {
		System.out.println("这是我的第一个aop");
		return "这是我的第一个aop";
	}
	
	@PostMapping("/aop1")
	@MyAnnotation(id = 2)
	public String testAop(@RequestBody String name) {
		System.out.println("这是我的第二个aop");
		return "这是我的第二个aop";
	}
	
	@PostMapping("/aop2")
	public String testObject(@RequestBody Object o) {
		System.out.println(o.toString());
		StringBuilder sb = new StringBuilder(o.toString());
		System.out.println(sb);
		return "这是我的第三个模拟流程";
	}
	
}
