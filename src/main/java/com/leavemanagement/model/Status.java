package com.leavemanagement.model;

public enum Status {
	
	APPROVED("approved"),
	DECLINED("declined"),
	NOT_PROCESSED("not_processed");
	
	private Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String value;

}
