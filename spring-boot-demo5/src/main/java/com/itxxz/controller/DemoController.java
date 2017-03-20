package com.itxxz.controller;

import java.util.List;

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
	
	@RequestMapping("query")
	public String query(SiteInfo entity){
		
		SiteInfo first = siteInfoService.findSiteInfoById(1);
		
		
		System.out.println("-----------查询id为1的信息-----------");
		System.out.println("编号："+first.getId());
		System.out.println("名称："+first.getName());
		System.out.println("描述："+first.getRemark());
		
		System.out.println("----------查询名称或描述中含有【螃蟹】的内容----------");
		entity.setName("螃蟹");
		entity.setRemark("螃蟹");
		List<SiteInfo> list = siteInfoService.findSiteInfo(entity);
		for(SiteInfo site:list){
			System.out.println("编号："+site.getId());
			System.out.println("名称："+site.getName());
			System.out.println("描述："+site.getRemark());
		}
		
		return "IT学习者-螃蟹";
	}
	
}
