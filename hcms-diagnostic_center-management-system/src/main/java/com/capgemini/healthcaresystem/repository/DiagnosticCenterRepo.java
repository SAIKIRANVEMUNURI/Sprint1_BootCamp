package com.capgemini.healthcaresystem.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;

@Repository
@Transactional
public interface DiagnosticCenterRepo extends JpaRepository<DiagnosticCenter, String> {
	
	public boolean existsByCenterName(String centerName);
}
