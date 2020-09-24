package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.CenterAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.NoCentersAreAvailableException;
import com.capgemini.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;



	public interface IDiagnosticCenterService {
		
		DiagnosticCenter addCenter(DiagnosticCenter center) throws  NoCentersAreAvailableException, CenterNameAlreadyExistsException, CenterAlreadyExistsException;
		
		List<DiagnosticCenter> getAllCenters() throws NoCentersAreAvailableException;
		
		DiagnosticCenter getCenterById(String centerId) throws SpecifiedCenterDoesnotExistException;
		
		boolean removeAllCenters() throws NoCentersAreAvailableException;
		
		boolean removeCenter(String centerId) throws SpecifiedCenterDoesnotExistException;
		

		
		
		
		
		
}
