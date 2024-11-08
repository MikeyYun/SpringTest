package com.mikeyyun.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mikeyyun.spring.test.mybatis.domain.RealEstate;

import com.mikeyyun.spring.test.mybatis.service.RealEstateService;


@RequestMapping("/mybatis/realestate/select")
@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("/1")
	public RealEstate realEstate(@RequestParam("id")int id) {
		
		// parameter 로 전달 받은 id 와 일치하는 부동산 정보 얻어오기
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public List<RealEstate> RealEstatePrice(@RequestParam("price") int price) {
		List<RealEstate> realEstatePrice = realEstateService.getRealEstatePrice(price);
		return realEstatePrice;
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<RealEstate> realEstateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		List<RealEstate> realEstateByAreaAndPrice = realEstateService.getRealEstateByAreaAndPrice(area, price);
		
		return realEstateByAreaAndPrice;
	}

}
