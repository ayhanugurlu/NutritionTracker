package com.diyetisyentakip.trackerapp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diyetisyentakip.trackerapp.model.WeightMeasurement;
import com.diyetisyentakip.trackerapp.repository.IWeightMeasurementRepository;

@RestController
public class WeightMeasurementController {

	@Autowired
	private IWeightMeasurementRepository weightMeasurementRepository;
	
	@RequestMapping(value="weightmeasurement", method = RequestMethod.GET)
	public List<WeightMeasurement> list(){
		return weightMeasurementRepository.findAll();
	}
	
	@RequestMapping(value="weightmeasurement/{id}", method = RequestMethod.GET)
	public WeightMeasurement get(@PathVariable Long id){
		return weightMeasurementRepository.findOne(id);
	}
	
	@RequestMapping(value="weightmeasurement", method = RequestMethod.POST)
	public WeightMeasurement create(@RequestBody WeightMeasurement weightMeasurement){
		return weightMeasurementRepository.saveAndFlush(weightMeasurement);
	}
	
	@RequestMapping(value="weightmeasurement/{id}", method = RequestMethod.PUT)
	public WeightMeasurement update(@PathVariable Long id, @RequestBody WeightMeasurement weightMeasurement){
		WeightMeasurement existingWeightMeasurement = weightMeasurementRepository.findOne(id);
		BeanUtils.copyProperties(weightMeasurement, existingWeightMeasurement);
		return weightMeasurementRepository.saveAndFlush(weightMeasurement);
	}
	
	@RequestMapping(value="weightmeasurement/{id}", method = RequestMethod.DELETE)
	public WeightMeasurement delete(@PathVariable Long id){
		WeightMeasurement existingShipwreck = weightMeasurementRepository.findOne(id);
		weightMeasurementRepository.delete(id);
		return existingShipwreck;
	}
}
