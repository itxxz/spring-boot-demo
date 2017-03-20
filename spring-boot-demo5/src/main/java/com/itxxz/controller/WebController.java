package com.itxxz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itxxz.entity.SiteInfo;
import com.itxxz.service.SiteInfoService;

@Controller
public class WebController {
	
	@Autowired
	SiteInfoService siteInfoService;

	@RequestMapping("page")
	public String page(SiteInfo entity,Model model){
		model.addAttribute("list", siteInfoService.findSiteInfo(entity));
		return "index";
	}
}
