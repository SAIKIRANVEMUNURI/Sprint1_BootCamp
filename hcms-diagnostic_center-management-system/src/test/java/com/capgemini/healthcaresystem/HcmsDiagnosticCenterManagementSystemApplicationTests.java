package com.capgemini.healthcaresystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.CenterNameAlreadyExistsException;
import com.capgemini.healthcaresystem.exception.SpecifiedCenterDoesnotExistException;
import com.capgemini.healthcaresystem.service.IDiagnosticCenterService;

@SpringBootTest
class HcmsDiagnosticCenterManagementSystemApplicationTests {

	
	@Autowired
	private IDiagnosticCenterService diagnostic;
	
	
	@Test
	public void centerByIdTest() throws SpecifiedCenterDoesnotExistException
	{
		
	DiagnosticCenter c = diagnostic.getCenterById("3399504");
	assertEquals("3399504",c.getCenterId());
	
		
	}
	
	
	@Test
	public void testCenterByIdException() {
		 
		 Assertions.assertThrows(SpecifiedCenterDoesnotExistException.class, () -> {
		      diagnostic.getCenterById("1");
		    });
	} 
	
	
	
	

}
