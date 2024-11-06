package com.mikeyyun.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> movieList() {
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movieMap = new HashMap<>();
		
		movieMap.put("title", "Parasite");
		movieMap.put("director", "JunHo Bong");
		movieMap.put("time", 131);
		movieMap.put("rate", 15);
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("title", "Life is beautiful");
		movieMap.put("director", "Roberto Beniny");
		movieMap.put("time", 116);
		movieMap.put("rate", 0);
		movieList.add(movieMap);
		
		movieMap = new HashMap<>();
		movieMap.put("title", "Inception");
		movieMap.put("director", "Christoper Nolan");
		movieMap.put("time", 147);
		movieMap.put("rate", 12);
		movieList.add(movieMap);
		
		return movieList;
	}
	
	@RequestMapping("/2")
	public List<InTest02ControllerPost> postList() {
		List<InTest02ControllerPost> postList = new ArrayList<>();
		InTest02ControllerPost post = new InTest02ControllerPost("Hello. It's good to see you.", "Siyun", "Can we get along with?");
		postList.add(post);
		
		postList.add(new InTest02ControllerPost("Wow, god tham", "bada", "I thought today's Friday, but It's Thursday."));
		postList.add(new InTest02ControllerPost("She only wanted to make sure that we were exposed to great literature", "Hunter", "..."));
		
		return postList;
		
	}
	
	@RequestMapping("/3")
	public ResponseEntity<InTest02ControllerPost> postError() {
		InTest02ControllerPost post = new InTest02ControllerPost("Hello. It's good to see you.", "Siyun", "Can we get along with?");
		
		ResponseEntity<InTest02ControllerPost> entity = new ResponseEntity<>(post, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	
}