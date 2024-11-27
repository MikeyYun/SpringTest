package com.mikeyyun.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mikeyyun.spring.test.jpa.domain.Company;
import com.mikeyyun.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ResponseBody
	@GetMapping("/create")
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		Company company1 = companyService.addCompany("미로틱", "컨텐츠 게임", "대기업", 2585);
		
		Company company2 = companyService.addCompany("렉터컨넥", "에듀", "대기업", 10000);
		
		companyList.add(company1);
		companyList.add(company2);
		
		return companyList;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		
		// id가 8인 회사 정보에서 규모를 중소기업, 사원수를 34명으로 수정
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		
		// id가 8인 회사정보 삭제
		companyService.deleteCompany(8);
		
		return "Delete Complete!!";
		
	}
	
	
}
