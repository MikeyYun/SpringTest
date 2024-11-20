package com.mikeyyun.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mikeyyun.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> selectWeatehrHistory();
	
	public int insertWeather(
			@Param("date") LocalDate date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);
}
