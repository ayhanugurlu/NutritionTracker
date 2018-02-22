package com.diyetisyentakip.trackerapp.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diyetisyentakip.trackerapp.model.User;
import com.diyetisyentakip.trackerapp.model.UserRole;
import com.diyetisyentakip.trackerapp.repository.IUserRepository;

@RestController
public class UserController {

	@Autowired
	private IUserRepository userRepository;
	
	@Transactional
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public @ResponseBody List<User> list() {
		List<User> result = userRepository.findAll();
		return result;
	}
	
	@RequestMapping(value="user/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Long id){
		return userRepository.findOne(id);
	}
	
	@RequestMapping(value="user", method = RequestMethod.POST)
	public User create(@RequestBody User user){
		return userRepository.saveAndFlush(user);
	}
	
	@RequestMapping(value="user/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody User user){
		User existingUser = userRepository.findOne(id);
		BeanUtils.copyProperties(user, existingUser);
		return userRepository.saveAndFlush(user);
	}
	
	@RequestMapping(value="user/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id){
		User existingUser = userRepository.findOne(id);
		userRepository.delete(id);
		return existingUser;
	}

}
