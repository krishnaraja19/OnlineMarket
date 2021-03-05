package com.online.market.productservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/product/server/")
public class ProductController {
	
	@Value("${server.port}")
	String port;
	
	
	@RequestMapping(value = "/showproduct", method = RequestMethod.GET)
	public String showProduct() {
		return "this instance is running on port:::  "+port;
		
	}

}
