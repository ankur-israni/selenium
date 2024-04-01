package com.shop.validator;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.shop.domain.Credentials;

public class CredentialsValidator implements Serializable{
	private static final long serialVersionUID = 1401683394656054628L;
	private static final String VALID_USERNAME="java";
	private static final String VALID_PASSWORD="java";

	public boolean authenticate(Credentials credentials){
		if(StringUtils.equalsIgnoreCase(VALID_USERNAME,credentials.getUsername()) && StringUtils.equalsIgnoreCase(VALID_PASSWORD, credentials.getPassword())){
			return true;
		}
		
		return false;
	}
	
}
