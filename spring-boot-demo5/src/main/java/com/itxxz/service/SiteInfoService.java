package com.itxxz.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public SiteInfo findSiteInfoById(int id){
		return siteInfoMapper.findSiteInfoById(id);
	}
	
	public List<SiteInfo> findSiteInfo(SiteInfo entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", entity.getName());
		map.put("remark", entity.getRemark());
		return siteInfoMapper.findSiteInfo(map);
	}
}
