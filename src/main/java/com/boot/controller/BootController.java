package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {
	@RequestMapping("/")
	public String index() {
		return "Spring boot home";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Spring boot home";
	}
	
}
