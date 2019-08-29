package org.sid.sec;

public interface SecurityParams {

	public static final String JWT_HEADER_NAME="Authorization";
	public static final String SECRET="hach@secret.com";
	public static final long EXPIRATION=24*10*3600;
	public static final String HEADER_PREFIX="Bearer ";
	
}
