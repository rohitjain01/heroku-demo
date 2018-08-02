package com.leavemanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.leavemanagement.dto.LoginDto;
import com.leavemanagement.model.Employee;
import com.leavemanagement.service.LeaveInfoService;
import com.leavemanagement.service.LoginService;

/**
 * This is the class which deals with validating login
 * credentials(username,password) from the home page.
 * 
 * @author akash
 * @since 12/07/2018
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private LeaveInfoService leaveInfoService;

	/**
	 * This method returns the signin page where user is required to enter
	 * username and password.
	 *
	 * @return signin default home page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "signin";
	}

	/**
	 * This method returns the applyleave jsp if the user is able to
	 * successfully sign in.
	 * 
	 * @param loginDto
	 *            this is used to get all values from user in LoginDto type
	 *            object.
	 * @return applyleave if the login credentials are correct.
	 * @return login returns the same login page if the credentials are not
	 *         correct.
	 */
	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public ModelAndView validateLogin(@RequestBody @Valid LoginDto loginDto) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = loginService.validateLoginCredentials(loginDto);
		if (employee != null) {
			if(employee.getRole().getName().equalsIgnoreCase("Admin")) {
				modelAndView.setViewName("leaveinfo");
				Gson gson = new Gson();
				modelAndView.addObject("leaveInfo", gson.toJson(leaveInfoService.showleaveInfo()));
			} else {
				modelAndView.setViewName("applyleave");
			}
			modelAndView.addObject("email", employee.getEmailId());
		} else {
			modelAndView.setViewName("login");
			modelAndView.addObject("error", "Invalid login credentials");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "signout", method = RequestMethod.GET)
	public ModelAndView signOut() {
		return new ModelAndView("signin");
	}
}
