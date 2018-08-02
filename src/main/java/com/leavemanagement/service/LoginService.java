package com.leavemanagement.service;
import org.springframework.stereotype.Service;

import com.leavemanagement.dto.LoginDto;
import com.leavemanagement.model.Employee;

@Service
public interface LoginService {
	
	public Employee validateLoginCredentials(LoginDto loginDto);

}
