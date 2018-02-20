package com.diyetisyentakip.trackerapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diyetisyentakip.trackerapp.model.Company;
import com.diyetisyentakip.trackerapp.model.User;
import com.diyetisyentakip.trackerapp.repository.ICompanyRepository;

@RestController
public class CompanyController {

	@Autowired
	private ICompanyRepository companyRepository;
	
	@RequestMapping(value="company", method = RequestMethod.GET)
	public List<Company> list(){
		return companyRepository.findAll();
	}
	
	@RequestMapping(path = "company/{id}/user", method = RequestMethod.GET)
	public List<User> listUsers(@PathVariable int id) {

		List<User> users = new ArrayList<User>();
		System.out.println("Users");
		return users;

	}
	
	@RequestMapping(value="company/{id}", method = RequestMethod.GET)
	public Company get(@PathVariable Long id){
		return companyRepository.findOne(id);
	}
	
	@RequestMapping(value="company", method = RequestMethod.POST)
	public Company create(@RequestBody Company company){
		return companyRepository.saveAndFlush(company);
	}
	
	@RequestMapping(value="company/{id}", method = RequestMethod.PUT)
	public Company update(@PathVariable Long id, @RequestBody Company company){
		Company existingCompany = companyRepository.findOne(id);
		BeanUtils.copyProperties(company, existingCompany);
		return companyRepository.saveAndFlush(company);
	}
	
	@RequestMapping(value="company/{id}", method = RequestMethod.DELETE)
	public Company delete(@PathVariable Long id){
		Company existingShipwreck = companyRepository.findOne(id);
		companyRepository.delete(id);
		return existingShipwreck;
	}
}
