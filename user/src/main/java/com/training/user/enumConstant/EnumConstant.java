package com.training.user.enumConstant;

public enum EnumConstant {
	
	 DB_URL("jdbc:mysql://localhost/TrainingDB?autoReconnect=true&useSSL=false&serverTimezone=UTC"),
     USER( "root"),
     PASS("");
	
	String value;
	
    EnumConstant(String value)
	{
		this.value = value;
	}
	
	public String getValue()
	{
		return value;
	}
    

}
