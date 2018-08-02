package com.leavemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.leavemanagement.service.EmployeeService;


@Controller
public class ApplyLeaveController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/applyleave")
	public ModelAndView initalizeApplyLeave(@RequestParam String email) {
		ModelAndView modelAndView = new ModelAndView();
		if(employeeService.validateEmail(email)) {
			modelAndView.setViewName("applyleave");
			modelAndView.addObject("email", email);
		} else {
			modelAndView.setViewName("signin");
			modelAndView.addObject("error", "Please login!");
		}
		return modelAndView;
	}
}
