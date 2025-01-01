package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Sports;

@FeignClient(name="SPORTS-SERVICE")
public interface SportsClients {
	
	@GetMapping("/getSportById/{sportId}")
	Sports getSportById(@PathVariable String sportId);
}
