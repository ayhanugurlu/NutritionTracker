package com.diyetisyentakip.trackerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyetisyentakip.trackerapp.model.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{

}
