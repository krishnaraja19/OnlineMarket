package com.online.market.productclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/online/product/client")
public class ProductClientController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	 @HystrixCommand(fallbackMethod = "fallback", groupKey = "Product",
	            commandKey = "Product",
	            threadPoolKey = "ProductThread"
	            )
	
	@RequestMapping("/getProduct")
	public String getProduct() {
		String url = "http://product-server/rest/product/server/showproduct";
        return restTemplate.getForObject(url, String.class);
	}
	 
	 public String fallback(Throwable hystrixCommand) {
	        return "Fall Back Hello world";
	    }
}
