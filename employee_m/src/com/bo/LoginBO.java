package com.bo;

import com.model.User;

import exception.BusinessException;

public class LoginBO {

	public boolean isValidUser(User user) throws BusinessException
	{
		boolean b=false;
		if(user!=null && user.getPassword()!=null && user.getRole()!=null && (user.getUser_id() +"").matches("[0-9]{1}") && (user.getPassword().matches("[0-9]{8}")))
		{
			b=true;
		}else
		{
			throw new BusinessException("Invalid Login Credentials");
		}
		return b;
	}
}
