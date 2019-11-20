package com.faith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.ILoginDao;

@RestController
public class LoginController {

	@Autowired
	ILoginDao loginDao;

	// to verify username and password for login
	@RequestMapping(value = "/api/login/usrname/password", method = RequestMethod.GET)
	public boolean verify(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		Boolean bol = loginDao.verifyUser(username, password);
		return bol;
	}

}
