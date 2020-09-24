package com.capgemini.healthcaresystem.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.CenterAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.NoCentersAreAvailableException;
import com.capgemini.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;
import com.capgemini.healthcaresystem.service.DiagnosticCenterServiceImplementation;



@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {
	@Autowired 
	private DiagnosticCenterServiceImplementation centerService;
	
	@GetMapping("/getcenter/center-Id/{centerId}")
	public DiagnosticCenter getCenterById(@PathVariable String centerId) throws SpecifiedCenterDoesnotExistException
	{
		return centerService.getCenterById(centerId);
	}
	@GetMapping("/getallcenters")
	public List<DiagnosticCenter> getAllCenters() throws NoCentersAreAvailableException
	{
		return centerService.getAllCenters();
	}
	
	@PostMapping("/addcenter")
	public DiagnosticCenter addCenter(@RequestBody DiagnosticCenter center) throws  NoCentersAreAvailableException, CenterNameAlreadyExistsException, CenterAlreadyExistsException
	{
	
		return centerService.addCenter(center);
	}

	@DeleteMapping("/removecenter/centerId/{centerId}")
	public boolean removeCenter(@PathVariable String centerId) throws SpecifiedCenterDoesnotExistException
	{
		return centerService.removeCenter(centerId);
	}
	
	@DeleteMapping("/removeAll")
	public boolean removeAllCenters() throws NoCentersAreAvailableException
	{
		return centerService.removeAllCenters();
	}

	

}