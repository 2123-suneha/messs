package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="STADIUM-SERVICE")
public interface StaduimClient {

}
