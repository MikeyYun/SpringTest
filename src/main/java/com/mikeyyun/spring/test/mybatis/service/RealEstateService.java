package com.mikeyyun.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikeyyun.spring.test.mybatis.domain.RealEstate;
import com.mikeyyun.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstrateRepository;
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstrateRepository.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getRealEstatePrice(int price) {
		
		List <RealEstate> realEstatePrice = realEstrateRepository.selectRealEstatePrice(price);
		
		return realEstatePrice;
	}

	public List<RealEstate> getRealEstateByAreaAndPrice(int area, int price) {
		List<RealEstate> realEstateByAreaAndPrice = realEstrateRepository.selectRealEstatebyAreaAndPrice(area, price);
		
		return realEstateByAreaAndPrice;
	}
}
