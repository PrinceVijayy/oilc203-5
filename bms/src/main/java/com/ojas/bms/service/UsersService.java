package com.ojas.bms.service;

import java.util.List;

import com.ojas.bms.model.Users;

public interface UsersService {
	public boolean register(Users user);

	public List<Users> login(String username, String password);

}
