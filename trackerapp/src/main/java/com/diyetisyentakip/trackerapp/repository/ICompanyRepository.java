package com.diyetisyentakip.trackerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyetisyentakip.trackerapp.model.Company;

public interface ICompanyRepository extends JpaRepository<Company, Long>{

}
