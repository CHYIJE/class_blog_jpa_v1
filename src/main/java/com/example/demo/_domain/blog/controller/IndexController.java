package com.example.demo._domain.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	
	// 정적 파일을 ---> 어떤 폴더에 넣어야 해  --> static에 넣어야 한다
	
	@GetMapping({"/index", "/index2"})
	public String index1(Model model) {
		
		String name = "이방원";
		int age = 586;
		String email = "<b>josun@namer.com</b>";
		String password = "asd123";
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		// src/main/resources/templates/index.mustache 를 찾을 수 있도록 파일 생성
		return "index";
	}
	
	
}
