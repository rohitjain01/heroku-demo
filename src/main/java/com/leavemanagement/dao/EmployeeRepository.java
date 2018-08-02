package com.leavemanagement.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leavemanagement.model.Employee;

/**
 * This is an interface with respect to entity Employee
 * 
 * @author akash
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	public List<Employee> findByActive(boolean active);
	
	public Employee findByUsernameIgnoreCaseAndPassword(String username, String password);
	
	public Employee findByEmailId(String emailId);
	
	public Employee findByEmailIdIgnoreCaseAndActive(String emailId, boolean active);
}
