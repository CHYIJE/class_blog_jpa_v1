package com.example.demo._domain.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo._domain.blog.Service.BlogService;
import com.example.demo._domain.blog.dto.ArticleDTO;
import com.example.demo._domain.blog.entity.Article;
import com.example.demo.common.ApiUtil;
import com.example.demo.common.errors.Exception400;

import lombok.RequiredArgsConstructor;


@RestController // @Controller + @Responsbody
@RequiredArgsConstructor
public class BlogApiController {
	
	private final BlogService blogService;
	
	// URL, 즉, 주소 설계 - http://localhost:8080/api/articles
	@PostMapping("/api/articles")
	public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO dto) {
		// 1. 인증 검사
		// 2. 유효성 검사
		Article savedArticle = blogService.save(dto);	
		return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
	}
	
	// URL, 즉, 주소 설계 - http://localhost:8080/api/articles
	@GetMapping(value = "/api/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiUtil<?> getAllArticle() {
			
		List<Article> articles = blogService.findAll();
		if(articles.isEmpty()) {
			// return new ApiUtil<>(new Exception400("게시글이 없습니다."));
			throw new Exception400("게시글이 없습니다.");
		}
			
		return new ApiUtil<>(articles);
	}
	
	// URL, 즉, 주소 설계 - http://localhost:8080/api/articles/1
	
	@GetMapping("/api/articles/{id}")
	public ApiUtil<?> findArticle(@PathVariable(name = "id") Integer id) {
		// 1. 유효성 검사 생략
		Article article = blogService.findById(id);
		return new ApiUtil<>(article);
	}
	
	// URL, 즉, 주소 설계 - http://localhost:8080/api/articles/1
		@PutMapping("/api/articles/{id}")
		public ApiUtil<?> updateArticle(@PathVariable(name = "id") Integer id, @RequestBody ArticleDTO dto) {
			
			// 1. 인증검사
			// 2. 유효성 검사
			Article updateArticle =	blogService.update(id, dto);
			return new ApiUtil<>(updateArticle);
		}
	
	
	
	
}
