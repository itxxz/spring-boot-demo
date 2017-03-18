package com.itxxz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("demo")
	public String demo(){
		return "IT学习者-螃蟹";
	}
}
