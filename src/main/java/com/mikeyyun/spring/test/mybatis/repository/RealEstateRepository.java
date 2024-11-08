package com.mikeyyun.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mikeyyun.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	
	public RealEstate selectRealEstate(@Param("id") int id);
	
	
	public List<RealEstate>selectRealEstatePrice(@Param("price") int price);
	
	public List<RealEstate>selectRealEstatebyAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
}
