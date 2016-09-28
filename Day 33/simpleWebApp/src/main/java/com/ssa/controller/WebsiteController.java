package com.ssa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan(basePackages="com.ssa")
@Controller
public class WebsiteController {

	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
		if(request.getParameter("name") != null) {
			mv.addObject("name", request.getParameter("name"));
		}
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("about");
		return mv;
	}
	
	@RequestMapping("/help")
	public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
		String [] messages = {
				"Message Text A", 
				"Message Text B",
				"Message Text C",
				"Message Text D",
				"Message Text E"
		}; 
		String id = request.getParameter("id");
		int idNum = Integer.parseInt(id);
		String helpMessage = messages[idNum];
		mv.addObject("id", id);
		mv.addObject("description", helpMessage);
		mv.setViewName("help");
		return mv;
	}
	
}
