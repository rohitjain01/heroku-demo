package com.leavemanagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.dao.EmployeeRepository;
import com.leavemanagement.dto.LoginDto;
import com.leavemanagement.model.Employee;

/**
 * In this class logic related to check login credentials from the database is
 * written
 * 
 * @author akash
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * This method finds the employee object with specific username(ignoring
	 * case) and password and further if the object is found Emailid of the
	 * object is returned and if not null is returned.
	 * 
	 * @param loginDto
	 * @return EmailId if the employee object is found.
	 * @return null if the employee object is not found.
	 */
	public Employee validateLoginCredentials(LoginDto loginDto) {
		return employeeRepository.findByUsernameIgnoreCaseAndPassword(loginDto.getUsername(),
				loginDto.getPassword());
	}
}
