package com.mikeyyun.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mikeyyun.spring.test.database.domain.Store;
import com.mikeyyun.spring.test.database.service.StoreService;

// Controller 은 오직 Request 와 Response 만 수행.
@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		// 가게 정보 리스트 얻어오기
		
		List<Store> storeList = storeService.getStoreList();
		
		return storeList;
		
	}
}
