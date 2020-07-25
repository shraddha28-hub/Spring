package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.PatientBO;

public class PatientDAOImpl implements PatientDAO {
         private DataSource ds;
         private static final String  PATIENT_INSERT_QUERY="INSERT INTO CORONA_PATIENT_DETAILS VALUES(PATIENT_NO_SEQ2.NEXTVAL,?,?,?,?,?,?)";
         PreparedStatement ps=null;	
         
	public PatientDAOImpl(DataSource ds) {
			this.ds = ds;
		}
	@Override
	public int insert(PatientBO bo) throws Exception {
		Connection con=null;
		int count=0;
		
		//get pooles jdbc connection
		con=ds.getConnection();
		//create preparedStatement object
		ps=con.prepareStatement(PATIENT_INSERT_QUERY);
		//set Data from BO
		ps.setString(1,bo.getPatient_Name());
		ps.setString(2,bo.getPatient_Address());
		ps.setString(3,bo.getHospital_Name());
		ps.setInt(4,bo.getPatient_Age());
		ps.setInt(5,bo.getNo_Day());
		ps.setInt(6,bo.getBill_Amount());
		
		//excute sql query
		count=ps.executeUpdate();
		//close connections
		ps.close();
		con.close();
		return count;
	}

}
