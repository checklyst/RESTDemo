package com.training.user.enumConstant;

public enum CommonMessageEnum {
	
	RECORD_INSER_SUCCESS("User Record successfully Inserted");
	
String value;
	
	CommonMessageEnum(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
}
