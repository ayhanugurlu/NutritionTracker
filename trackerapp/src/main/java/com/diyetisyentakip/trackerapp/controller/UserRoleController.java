package com.diyetisyentakip.trackerapp.controller;

import java.util.ArrayList;
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

import com.diyetisyentakip.trackerapp.model.Company;
import com.diyetisyentakip.trackerapp.model.User;
import com.diyetisyentakip.trackerapp.model.UserRole;
import com.diyetisyentakip.trackerapp.repository.IUserRoleRepository;

@RestController
public class UserRoleController {

	@Autowired
	private IUserRoleRepository userRoleRepository;
	
	@Transactional
	@RequestMapping(value = "userRole", method = RequestMethod.GET)
	public @ResponseBody List<UserRole> list() {
		List<UserRole> result = userRoleRepository.findAll();
		return result;
	}

	@RequestMapping(value="userRole/{id}", method = RequestMethod.GET)
	public UserRole get(@PathVariable Long id){
		return userRoleRepository.findOne(id);
	}
	
	@RequestMapping(value="userRole", method = RequestMethod.POST)
	public UserRole create(@RequestBody UserRole userRole){
		return userRoleRepository.saveAndFlush(userRole);
	}
	
	@RequestMapping(value="userRole/{id}", method = RequestMethod.PUT)
	public UserRole update(@PathVariable Long id, @RequestBody UserRole userRole){
		UserRole existingRole = userRoleRepository.findOne(id);
		BeanUtils.copyProperties(userRole, existingRole);
		return userRoleRepository.saveAndFlush(userRole);
	}
	
	@RequestMapping(value="userRole/{id}", method = RequestMethod.DELETE)
	public UserRole delete(@PathVariable Long id){
		UserRole existingRole = userRoleRepository.findOne(id);
		userRoleRepository.delete(id);
		return existingRole;
	}
}
