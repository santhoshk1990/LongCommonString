package com.spring.lcs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.lcs.service.FetchService;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/findLcs", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView getLCS(@RequestParam("string1") String str1, @RequestParam("string2") String str2, @RequestParam("string3") String str3, HttpServletRequest request, HttpServletResponse response) 
	{
				
		if(str1.equals(str2) || str1.equals(str3) || str2.equals(str3))
			
			return new ModelAndView("exception");			
		else 
		{
				
		FetchService fs = new FetchService();
		
		String result = fs.findLCS(str1, str2, str3);
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", result);
				
		return mv; 
		
        }
     }  
}
