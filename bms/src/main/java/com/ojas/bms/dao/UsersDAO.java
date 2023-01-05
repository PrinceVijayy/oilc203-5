package com.ojas.bms.dao;

import java.util.List;

import com.ojas.bms.model.Users;

public interface UsersDAO {
	
	public boolean register(Users user);

	public List<Users> login(String username, String password);
}
