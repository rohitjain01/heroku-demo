package com.leavemanagement.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.dto.EmployeeDto;
import com.leavemanagement.dto.ResponseDto;

@Service
public interface EmployeeService {
	
	public List<EmployeeDto> findAllEmployee();

	public ResponseDto addupdateEmployee(EmployeeDto employeeDto);

	public boolean activateDeactivateEmployee(EmployeeDto employeeDto, long id);
	
	public boolean validateEmail(String emailId);
	
	public boolean validateAdmin(String emailId);
}
