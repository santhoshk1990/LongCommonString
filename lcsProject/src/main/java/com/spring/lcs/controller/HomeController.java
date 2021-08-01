package com.spring.lcs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/findLcs", method = RequestMethod.POST)
	public ModelAndView findLCS(@RequestParam("string1") String str1, @RequestParam("string2") String str2, @RequestParam("string3") String str3, HttpServletRequest request, HttpServletResponse response)
			{
				int maxlen = 0; 		
				int m = str1.length(), n = str2.length(), o = str3.length();
				int endingIndex = m;
				String result;
				int[][][] lookup = new int[m + 1][n + 1][o + 1];

				for (int i = 1; i <= m; i++)
				{
					for (int j = 1; j <= n; j++)
					{
						for (int k = 1; k <= o; k++)
						{
						if (str1.charAt(i - 1) == str2.charAt(j - 1) && str1.charAt(i - 1) == str2.charAt(k - 1) )
						{
							lookup[i][j][k] = lookup[i - 1][j - 1][k - 1] + 1;

							if (lookup[i][j][k] > maxlen)
							{
								maxlen = lookup[i][j][k];
								endingIndex = i;
							}
						}
					    }
				     }
			      }
				result = str1.substring(endingIndex - maxlen, endingIndex);
				
				ModelAndView mv = new ModelAndView();
				mv.setViewName("display");
				mv.addObject("result", result);
				
				return mv; 

			}
}
