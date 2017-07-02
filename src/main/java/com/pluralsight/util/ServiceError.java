package com.pluralsight.util;

public class ServiceError {

	private int code;
	private String messgae;
	
	public ServiceError() {
	}

	public ServiceError(int code, String messgae) {
		this.code = code;
		this.messgae = messgae;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessgae() {
		return messgae;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
}
