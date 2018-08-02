package com.leavemanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.leavemanagement.model.LeaveInfo;

public interface LeaveInfoRepository extends CrudRepository<LeaveInfo, Long> {
	
	public List<LeaveInfo> findByActive(boolean active);
	
	public List<LeaveInfo> findByActiveOrderByFrom(boolean active);
	
}
