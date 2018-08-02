package com.leavemanagement.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.leavemanagement.model.Status;

public class LeaveInfoDto {
	private long id;
	@NotNull @NotEmpty
	private String empId;
	@NotNull 
	private String message;
	@NotNull @NotEmpty
	private String from;
	@NotNull @NotEmpty
	private String to;
	@NotNull @NotEmpty
	private Status status;
	@NotNull @NotEmpty
	private String declineReason;
	@NotNull
	private boolean active;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getDeclineReason() {
		return declineReason;
	}
	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
