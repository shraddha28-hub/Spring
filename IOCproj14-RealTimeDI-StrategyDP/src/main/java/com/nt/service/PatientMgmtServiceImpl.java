package com.nt.service;

import com.nt.bo.PatientBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDTO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
       private PatientDAO dao;
       int count=0;
       
	public PatientMgmtServiceImpl(PatientDAO dao) {
		this.dao = dao;
	}

	@Override
	public String calculateChargeOfTotalDays(PatientDTO dto) throws Exception {
		int Bill_Amount=0;
		PatientBO bo=null;
		//create business logic to calculate total amount
		Bill_Amount=dto.getNo_Day()*3000;
		//prepare Patient Bo object persistable data
		bo=new PatientBO();
		bo.setPatient_Name(dto.getPatient_Name());
		bo.setPatient_Address(dto.getPatient_Address());
		bo.setHospital_Name(dto.getHospital_Name());
		bo.setPatient_Age(dto.getNo_Day());
		bo.setNo_Day(dto.getNo_Day());
		bo.setBill_Amount(Bill_Amount);
		//use DAO
		count=dao.insert(bo);
		//process result
		if(count==0)
			return "Patient Registration Failed";
		else
			return "Patient Registration Success :: no of days      "+dto.getNo_Day()+"    and BillAmount   "+Bill_Amount;
		}
}
