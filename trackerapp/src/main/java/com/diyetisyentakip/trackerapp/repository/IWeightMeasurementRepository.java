package com.diyetisyentakip.trackerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyetisyentakip.trackerapp.model.WeightMeasurement;

public interface IWeightMeasurementRepository extends JpaRepository<WeightMeasurement,Long> {
	
}
