package com.capgemini.healthcaresystem.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.CenterAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.NoCentersAreAvailableException;
import com.capgemini.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;
import com.capgemini.healthcaresystem.repository.DiagnosticCenterRepo;


@Service
public class DiagnosticCenterServiceImplementation implements IDiagnosticCenterService{
	
	
	Random random=new Random();
	@Autowired
	private DiagnosticCenterRepo repository;
	
		@Override
		public DiagnosticCenter getCenterById(String centerId) throws SpecifiedCenterDoesnotExistException {
			boolean existingCenter = repository.existsById(centerId);
			if(existingCenter)
			{
				DiagnosticCenter center = repository.getOne(centerId);
				return center;
			}
			throw new SpecifiedCenterDoesnotExistException("Center with center id "+centerId+"Doesnot exist");
			
		}
			
		@Override
		public List<DiagnosticCenter> getAllCenters() throws NoCentersAreAvailableException {
			
			List<DiagnosticCenter> centerList=repository.findAll();
			
			if(centerList.isEmpty())
			{
				throw new NoCentersAreAvailableException("No center is present");	
			}
			
				return centerList;	
		}

		@Override
		public DiagnosticCenter addCenter(DiagnosticCenter center) throws NoCentersAreAvailableException, CenterNameAlreadyExistsException, CenterAlreadyExistsException {
			center.setCenterId(String.valueOf(random.nextInt(10000000)));
			if(repository.existsById(center.getCenterId()))
			{
				throw new CenterAlreadyExistsException("Center already exists kindly enter another center ID");
			}
			
			if(repository.existsByCenterName(center.getCenterName()))
			{
				throw new CenterNameAlreadyExistsException("Center Name Already exists Kindly enter some other name ");
			}
			
			return repository.save(center);
			
		}

		
		@Override
		public boolean removeAllCenters() throws NoCentersAreAvailableException {
			List<DiagnosticCenter> centerList=repository.findAll();
			if(centerList.isEmpty())
			{
				
				throw new NoCentersAreAvailableException("Centers are not present");
			}
			repository.deleteAll();
			return true;
		}
		
		@Override
		public boolean removeCenter(String centerId) throws  SpecifiedCenterDoesnotExistException {
			
			if(repository.existsById(centerId))
			{
				repository.deleteById(centerId);
				return true;
			}
		
			else {
				throw new SpecifiedCenterDoesnotExistException("Center doesnot exist kindly enter another center ID");
			}
		}
		
		
	
		
		
		
		

}