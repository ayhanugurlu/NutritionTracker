package com.diyetisyentakip.trackerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyetisyentakip.trackerapp.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}

