package com.itxxz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itxxz.entity.SiteInfo;
import com.itxxz.service.SiteInfoService;

@RestController
public class DemoController {
	
	@Autowired
	SiteInfoService siteInfoService;

	@RequestMapping("demo")
	public String demo(){
		SiteInfo site = siteInfoService.findFirstSiteInfo();
		System.out.println("名称："+site.getName());
		System.out.println("描述："+site.getRemark());
		System.out.println("官网："+site.getUrl());
		return "IT学习者-螃蟹";
	}
}
