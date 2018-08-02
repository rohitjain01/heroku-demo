package com.leavemanagement.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagement.dao.EmployeeRepository;
import com.leavemanagement.dao.LeaveInfoRepository;
import com.leavemanagement.dto.LeaveInfoDto;
import com.leavemanagement.model.LeaveInfo;

/**
 * This class deals with all the buisness logic related to leave information
 * 
 * @author akash
 */
@Service
public class LeaveInfoServiceImpl implements LeaveInfoService {
	
	@Autowired
	LeaveInfoRepository leaveInfoRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * This method returns the list of the leaves in the format like active
	 * leaves are shown first then unactive leaves and in these leaves are
	 * displayed in ascending order of from date.
	 * 
	 * @param Unused
	 * @return list<LeaveInfoDto> returns the list of leave information
	 */
	public List<LeaveInfoDto> showleaveInfo() {
		List<LeaveInfo> leaveInfos = leaveInfoRepository.findByActiveOrderByFrom(true);
		List<LeaveInfo> leaveInfos1 = leaveInfoRepository.findByActiveOrderByFrom(false);
		List<LeaveInfoDto> leaveInfoDtos = new ArrayList<>();
		for(LeaveInfo leaveInfo: leaveInfos) {
			LeaveInfoDto leaveInfoDto = new LeaveInfoDto();
			leaveInfoDto.setId(leaveInfo.getId());
			leaveInfoDto.setEmpId(leaveInfo.getEmployee().getEmailId());
			leaveInfoDto.setFrom(simpleDateFormat.format(leaveInfo.getFrom()));
			leaveInfoDto.setTo(simpleDateFormat.format(leaveInfo.getTo()));
			leaveInfoDto.setMessage(leaveInfo.getMessage());
			leaveInfoDto.setStatus(leaveInfo.getStatus() );
			leaveInfoDto.setDeclineReason(leaveInfo.getDeclineReason());
			leaveInfoDto.setActive(leaveInfo.isActive());
			leaveInfoDtos.add(leaveInfoDto);
		} 
		for(LeaveInfo leaveInfo: leaveInfos1) {
			LeaveInfoDto leaveInfoDto = new LeaveInfoDto();
			leaveInfoDto.setId(leaveInfo.getId());
			leaveInfoDto.setEmpId(leaveInfo.getEmployee().getEmailId());
			leaveInfoDto.setFrom(simpleDateFormat.format(leaveInfo.getFrom()));
			leaveInfoDto.setTo(simpleDateFormat.format(leaveInfo.getTo()));
			leaveInfoDto.setMessage(leaveInfo.getMessage());
			leaveInfoDto.setStatus(leaveInfo.getStatus() );
			leaveInfoDto.setDeclineReason(leaveInfo.getDeclineReason());
			leaveInfoDto.setActive(leaveInfo.isActive());
			leaveInfoDtos.add(leaveInfoDto);
		} 
		return leaveInfoDtos;
	}

	/**
	 * This method adds or updates a leave information,converting the date from
	 * string into sql format.
	 * 
	 * @param leaveInfoDto
	 * @return true if the leave information is added or updated successfully.
	 */
	public boolean addUpdateLeaveInfo(LeaveInfoDto leaveInfoDto){
		LeaveInfo leaveInfo= new LeaveInfo();
		leaveInfo.setEmployee(employeeRepository.findByEmailId(leaveInfoDto.getEmpId()));
		try {
			leaveInfo.setFrom(simpleDateFormat.parse(leaveInfoDto.getFrom()));
			leaveInfo.setTo(simpleDateFormat.parse(leaveInfoDto.getTo()));
		}catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		leaveInfo.setMessage(leaveInfoDto.getMessage());
		leaveInfo.setActive(leaveInfoDto.isActive());
		leaveInfoRepository.save(leaveInfo);
		return true; 
	}

	/**
	 * This method changes the status of leave to false,i.e. leave will no
	 * longer be active after this method.
	 * 
	 * @param leaveInfoDto
	 *            the object that comes from the user interface comes in this
	 * @param id
	 *            this parameter takes in the id whose leave is to be set false
	 * @return boolean if the id is present true will be returned otherwise
	 *         false.
	 * 
	 */
	public boolean deleteLeave(LeaveInfoDto leaveInfoDto, long id) {
		Optional<LeaveInfo> optional = leaveInfoRepository.findById(id);
		if(optional.isPresent()) {
			LeaveInfo leaveInfo = optional.get();
			leaveInfo.setActive(false);
			leaveInfoRepository.save(leaveInfo);
			return true;
		} else {
			return false;
		}
	}
}
  