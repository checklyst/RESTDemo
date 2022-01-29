package com.training.user.enumConstant;

public enum EnumConstant {
	
	 DB_URL("jdbc:mysql://103.127.146.94/TrainingDB?autoReconnect=true&useSSL=false&serverTimezone=UTC"),
     USER( "meraemi_user"),
     PASS("fTxgEmpo");
	
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
