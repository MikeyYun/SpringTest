package com.mikeyyun.spring.test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mikeyyun.spring.test.mybatis.domain.RealEstate;

import com.mikeyyun.spring.test.mybatis.service.RealEstateService;


@RequestMapping("/mybatis/realestate")
@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateService realEstateService;
	
	@ResponseBody
	@RequestMapping("select/1")
	public RealEstate realEstate(@RequestParam("id")int id) {
		
		// parameter 로 전달 받은 id 와 일치하는 부동산 정보 얻어오기
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate;
	}
	
	@ResponseBody
	@RequestMapping("select/2")
	public List<RealEstate> RealEstatePrice(@RequestParam("price") int price) {
		List<RealEstate> realEstatePrice = realEstateService.getRealEstatePrice(price);
		return realEstatePrice;
	}
	
	@ResponseBody
	@RequestMapping("select/3")
	public List<RealEstate> realEstateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		
		List<RealEstate> realEstateByAreaAndPrice = realEstateService.getRealEstateByAreaAndPrice(area, price);
		
		return realEstateByAreaAndPrice;
	}
	
	@ResponseBody
	@RequestMapping("/insert/1")
	public String createRealEstateByObject() {
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("한남동 유엔빌리지 파트코인빌 201호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(670000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		
		return "입력 성공 : " + count;
		
	}
	
	@ResponseBody
	@RequestMapping("/insert/2")
	public String creatRealEstate(@RequestParam("realtorId") int realtorId) {
		
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		
		int count = realEstateService.addRealEstate(realtorId, "NYC H", 100, "월세", 10000000, 10000);
		
		return "입력 성공 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String updateRealEstate() {
		int count = realEstateService.updateRealEstate(2, "전세", 70000);
		
		return "수정 성공 : " + count;
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRealEstate(@RequestParam("id") int id) {
		int count = realEstateService.deleteRealEstate(id);
		
		return "삭제 성공 : " + count;
	}

}
