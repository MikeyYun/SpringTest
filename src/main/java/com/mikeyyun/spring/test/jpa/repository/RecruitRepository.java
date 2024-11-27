package com.mikeyyun.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikeyyun.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>{
	
	// WHERE `companyId` = #{companyId}
	public List<Recruit> findByCompanyId(int companyId);
}
