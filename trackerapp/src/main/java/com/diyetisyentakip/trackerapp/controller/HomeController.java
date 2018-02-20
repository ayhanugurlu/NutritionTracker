package com.diyetisyentakip.trackerapp.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String Home(){
		return "Das Boot, Ready for duty";
	}
}
