package com.leavemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leavemanagement.dto.LeaveInfoDto;

@Service
public interface LeaveInfoService {
	
	public List<LeaveInfoDto> showleaveInfo();

	public boolean addUpdateLeaveInfo(LeaveInfoDto leaveInfoDto);

	public boolean deleteLeave(LeaveInfoDto leaveInfoDto, long id);
}
