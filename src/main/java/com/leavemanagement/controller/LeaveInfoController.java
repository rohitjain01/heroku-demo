package com.leavemanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.leavemanagement.dto.LeaveInfoDto;
import com.leavemanagement.service.EmployeeService;
import com.leavemanagement.service.LeaveInfoService;

/**This class is to deal with all the queries related to leave information 
 * like adding or deleting or showing all the leave informations
 * @author akash
 */
@Controller
@Validated
public class LeaveInfoController {
	
	@Autowired
	private LeaveInfoService leaveInfoService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/leaveInfo")
	public ModelAndView initalizeLeaveInfo(@RequestParam String email) {
		ModelAndView modelAndView=new ModelAndView();
		if(employeeService.validateAdmin(email)) {
			modelAndView.setViewName("leaveinfo");
			Gson gson = new Gson();
			modelAndView.addObject("leaveInfo", gson.toJson(leaveInfoService.showleaveInfo()));
			modelAndView.addObject("email", email);
		} else {
			modelAndView.setViewName("signin");
			modelAndView.addObject("error", "Please login!");
		}
		return modelAndView;
	}

	/**This method adds information to the database about the leave required by the user.
	 * 
	 * @param leaveInfoDto the information that is to be entered by user comes through leaveInfoDto type
	 * @return boolean if query is successfully added it returns true otherwise false
	 */
	@PostMapping(value="/leaveInfo/save")
	@ResponseBody
	public boolean addUpdateLeaveInfo(@RequestBody LeaveInfoDto leaveInfoDto){
		return leaveInfoService.addUpdateLeaveInfo(leaveInfoDto);
	}
	
	/**
	 * This method deals with showing leave information which are added, deleted
	 * or updated.
	 * 
	 * @return List<LeaveInfoDto> the list of leave information is returned in
	 *         the form of LeaveInfoDto object.
	 */
	@RequestMapping(value="/leaveinfo/show")
	@ResponseBody
	public List<LeaveInfoDto> showLeaveInfo() {
		return leaveInfoService.showleaveInfo();
	}
	
	/**
	 * This method only deletes the leave application request of the particular
	 * employee and the employee cannot again revive the request.
	 * 
	 * @param leaveInfoDto
	 *            takes in whole the information of leave
	 * @param id
	 *            it is the id of the employee whose leave request is to be
	 *            deleted.
	 * @return
	 */
	@RequestMapping("/leaveinfo/delete/")
	@ResponseBody
	public boolean deleteLeave(@RequestBody LeaveInfoDto leaveInfoDto, @RequestParam int id){
		return leaveInfoService.deleteLeave(leaveInfoDto,id);
	}
}

