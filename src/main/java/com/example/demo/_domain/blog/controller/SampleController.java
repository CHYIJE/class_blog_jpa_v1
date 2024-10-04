package com.example.demo._domain.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class SampleController {
	
	// http://localhost:8080/  (GET) 요청
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		
		// 뷰 리졸브 동작
		request.setAttribute("name", "word");
		// hello --> src/main/resources/templates/hello.mustache
		// model.addAttribute("name", "word");
		return "hello";
	}
}
