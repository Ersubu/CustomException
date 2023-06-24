package com.dakr.customException;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static long serialVersionUID = 1L; 
	
	public String errorCode;
	public String ErrorMessege;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessege() {
		return ErrorMessege;
	}
	public void setErrorMessege(String errorMessege) {
		ErrorMessege = errorMessege;
	}
	@Override
	public String toString() {
		return "BusinessException [errorCode=" + errorCode + ", ErrorMessege=" + ErrorMessege + "]";
	}
	public BusinessException(String errorCode, String errorMessege) {
		super();
		this.errorCode = errorCode;
		ErrorMessege = errorMessege;
	}
	
	
	public BusinessException()
	{
		
	}
	
	

}
