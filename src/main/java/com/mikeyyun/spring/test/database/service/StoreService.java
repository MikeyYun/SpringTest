package com.mikeyyun.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikeyyun.spring.test.database.domain.Store;
import com.mikeyyun.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	// 가게 리스트 얻어오기
	@Autowired
	private StoreRepository storeRepository;
	
		
	// store 테이블의 모든 행 조회
	public List<Store> getStoreList() {
		
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
		
	}
}