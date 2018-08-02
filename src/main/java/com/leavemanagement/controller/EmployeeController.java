package com.leavemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.leavemanagement.dto.EmployeeDto;
import com.leavemanagement.dto.ResponseDto;
import com.leavemanagement.service.EmployeeService;

/**
 * This class EmployeeController is the controller class which deals with all
 * the employee related queries like (adding,updating,activating&deactivating)
 * details.
 */
@Controller
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * This is the method which is used to add details of an employee or update
	 * details of an existing employee. It responds to the http call
	 * /employee/{id}.
	 * 
	 * @param employeeDto
	 *            this is the parameter which takes all the values from user in
	 *            json format and gives it to method
	 * @param id
	 *            This parameter is used in updating the details of the employee
	 *            according to the id
	 * @return List<Employee> it returns the list of employees from the
	 *         database.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/employee/save")
	@ResponseBody
	public ResponseDto addupdateEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.addupdateEmployee(employeeDto);
	}

	/**
	 * This is the method to put the status record of the employee in the
	 * database, whether particular employee is active in the company or not.
	 * 
	 * @param active
	 *            it gets the particular parameter from the user
	 * @param name
	 *            it refers to the name of the employee to which activation or
	 *            deactivation is to be performed
	 * @return boolean
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/employee/activation/")
	@ResponseBody
	public boolean activateDeactivateEmployee(@RequestBody EmployeeDto employeeDto, @RequestParam long id) {
		return employeeService.activateDeactivateEmployee(employeeDto, id);
	}

	/**
	 * This is the method to display the employee details on the admin interface
	 * in User Management System table.
	 * 
	 * @param employeeDetailsDto
	 *            in this parameter all values are set which are needed to be
	 *            display on UI
	 * @return
	 */
	@RequestMapping(value = "showemployeedetails", method = RequestMethod.GET)
	public ModelAndView showEmployeeDetails(@RequestParam String email) {
		ModelAndView modelAndView = new ModelAndView();
		if(employeeService.validateAdmin(email)) {
			List<EmployeeDto> employeeDetails = employeeService.findAllEmployee();
			Gson gson = new Gson();
			modelAndView.addObject("employeeDetails", gson.toJson(employeeDetails));
			modelAndView.addObject("email", email);
			modelAndView.setViewName("UserManagement");
		} else {
			modelAndView.setViewName("signin");
			modelAndView.addObject("error", "Please login!");
		}
		return modelAndView;
	}
}
