package com.leavemanagement.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.dao.EmployeeRepository;
import com.leavemanagement.dto.EmployeeDto;
import com.leavemanagement.dto.ResponseDto;
import com.leavemanagement.model.Employee;

/**
 * This is a class which implements the EmployeeService interface and deals with
 * all business logics related to employee.
 * 
 * @author akash
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * This method is in reference to the method called from controller class
	 * which deals with returning all the employees in the order active to
	 * inactive.
	 * 
	 * @param Nothing
	 * @return List<Employee> returns the list of employees from the database
	 *         through employeeRepository
	 */
	public List<EmployeeDto> findAllEmployee(){
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for(Employee employee: employees) {
			EmployeeDto employeeDto=new EmployeeDto();
			employeeDto.setId(employee.getId());
			employeeDto.setName(employee.getName());
			employeeDto.setContact(employee.getContact());
			employeeDto.setEmailId(employee.getEmailId());
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setUsername(employee.getUsername());
			employeeDto.setPasssword(employee.getPassword());
			employeeDto.setActive(true);
			employeeDtos.add(employeeDto);
		}
		return employeeDtos;
	}
	
	/**
	 * This is the method which deals when referred through controller class and
	 * adds or updates the details of the employee and does nothing if the id
	 * requested is less than 1.
	 * 
	 * @param employeeDto
	 * @param id
	 * @return boolean
	 */
	public ResponseDto addupdateEmployee(EmployeeDto employeeDto) {
		ResponseDto responseDto = new ResponseDto();
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setAddress(employeeDto.getAddress());
		employee.setName(employeeDto.getName());
		employee.setContact(employeeDto.getContact());
		employee.setEmailId(employeeDto.getEmailId());
		employee.setPassword(employeeDto.getPasssword());
		employee.setUsername(employeeDto.getUsername());
		employee.setActive(true);
		employeeRepository.save(employee);
		responseDto.setSuccess(true);
		responseDto.setData(findAllEmployee());
		return responseDto;
	}	
	
	/**
	 * This is the method called in reference to the method in controller class
	 * and sets the variable active of model class Employee taking value of
	 * variable active from EmployeeDto.
	 * 
	 * @param active
	 * @param name
	 * @return boolean
	 */
	public boolean activateDeactivateEmployee(EmployeeDto employeeDto, long id){
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			Employee employee = optional.get();
			employee.setActive(employeeDto.isActive());
			employeeRepository.save(employee);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateEmail(String emailId) {
		return employeeRepository.findByEmailIdIgnoreCaseAndActive(emailId, true) != null ? true : false;
	}
	
	@Override
	public boolean validateAdmin(String emailId) {
		Employee employee = employeeRepository.findByEmailIdIgnoreCaseAndActive(emailId, true);
		if(employee != null && employee.getRole().getName().equalsIgnoreCase("Admin")) {
			return true;
		}
		return false;
	}
}