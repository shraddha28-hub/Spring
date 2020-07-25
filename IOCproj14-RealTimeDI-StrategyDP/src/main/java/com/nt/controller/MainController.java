package com.nt.controller;

import com.nt.dto.PatientDTO;
import com.nt.service.PatientMgmtService;
import com.nt.vo.PatientVO;

public class MainController {
       public PatientMgmtService service;
       String result=null;
       
	public MainController(PatientMgmtService service) {
		this.service = service;
	}
	
	public String processPatient(PatientVO vo) throws Exception{
		PatientDTO dto=null;
		//convert vo class object to dto class
		dto=new PatientDTO();
		dto.setPatient_Name(vo.getPatient_Name());
	     dto.setPatient_Address(vo.getPatient_Address());
	     dto.setHospital_Name(vo.getHospital_Name());
	     dto.setPatient_Age(Integer.parseInt(vo.getPatient_Age()));
	     dto.setNo_Day(Integer.parseInt(vo.getNo_Day()));
		//use service
		result=service.calculateChargeOfTotalDays(dto);
		return result;
	}
	       
}
