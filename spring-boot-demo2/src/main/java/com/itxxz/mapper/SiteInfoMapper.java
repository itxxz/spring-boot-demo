package com.itxxz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.itxxz.entity.SiteInfo;

@Mapper
public interface SiteInfoMapper {

	@Select("select * from itxxz_site limit 1")
	SiteInfo findFirstSiteInfo();
}
