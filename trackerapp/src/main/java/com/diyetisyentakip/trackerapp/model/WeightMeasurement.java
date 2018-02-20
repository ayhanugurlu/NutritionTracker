package com.diyetisyentakip.trackerapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WeightMeasurement {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;
	Date measurementDate;
	float weight;
	float bmi;
	float fatPercent;
	float fatMass;
	float ffm;
	float tbw;
	int visceralFatRating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NUTRITIONIST_ID", nullable = false)
	User nutritionist;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID", nullable = false)
	User client;
	
	
	
	public WeightMeasurement() {
	}

	public WeightMeasurement(Long id, Date measurementDate, float weight, float bmi, float fatPercent, float fatMass,
			float ffm, float tbw, int visceralFatRating) {
		super();
		this.id = id;
		this.measurementDate = measurementDate;
		this.weight = weight;
		this.bmi = bmi;
		this.fatPercent = fatPercent;
		this.fatMass = fatMass;
		this.ffm = ffm;
		this.tbw = tbw;
		this.visceralFatRating = visceralFatRating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public User getNutritionist() {
		return nutritionist;
	}

	public void setNutritionist(User nutritionist) {
		this.nutritionist = nutritionist;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Date getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(Date measurementDate) {
		this.measurementDate = measurementDate;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getBmi() {
		return bmi;
	}

	public void setBmi(float bmi) {
		this.bmi = bmi;
	}

	public float getFatPercent() {
		return fatPercent;
	}

	public void setFatPercent(float fatPercent) {
		this.fatPercent = fatPercent;
	}

	public float getFatMass() {
		return fatMass;
	}

	public void setFatMass(float fatMass) {
		this.fatMass = fatMass;
	}

	public float getFfm() {
		return ffm;
	}

	public void setFfm(float ffm) {
		this.ffm = ffm;
	}

	public float getTbw() {
		return tbw;
	}

	public void setTbw(float tbw) {
		this.tbw = tbw;
	}

	public int getVisceralFatRating() {
		return visceralFatRating;
	}

	public void setVisceralFatRating(int visceralFatRating) {
		this.visceralFatRating = visceralFatRating;
	}
	
	
}
