package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name="nm", required=false, defaultValue="이름...") 
		String name, Model model) {
		
		model.addAttribute("name", name);
		
		return "hello";
	}
}
