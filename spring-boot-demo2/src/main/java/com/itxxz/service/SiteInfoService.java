package com.itxxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.entity.SiteInfo;
import com.itxxz.mapper.SiteInfoMapper;

@Service
public class SiteInfoService {

	@Autowired
	SiteInfoMapper siteInfoMapper;
	
	public SiteInfo findFirstSiteInfo(){
		return siteInfoMapper.findFirstSiteInfo();
	}
}
