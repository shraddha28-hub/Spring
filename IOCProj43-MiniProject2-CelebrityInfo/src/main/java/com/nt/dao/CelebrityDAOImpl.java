package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.CelebrityBO;


public class CelebrityDAOImpl implements CelebrityDAO {
   private static final String GET_CELEBRITYINFO_BT_DESGS="SELECT * FROM CELEBRITYINFO WHERE CITY IN(?,?,?)";
	private DataSource ds;
	
	
	public CelebrityDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public List<CelebrityBO> getAllCelebrityByDesgs(String desg1, String desg2, String desg3) throws Exception {

		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CelebrityBO> listBO=null;
		CelebrityBO bo=null;
		try {
			//get Pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(GET_CELEBRITYINFO_BT_DESGS);
			//set values to query params
			ps.setString(1,desg1); ps.setString(2,desg2); ps.setString(3, desg3);
			//execute the query
			rs=ps.executeQuery();
			//convert ResultSet object records to ListBO
			listBO=new ArrayList();
			while(rs.next()) {
			//	System.out.println(rs.getInt(1));
				bo=new CelebrityBO();
				//copy each record of ResultSet obj to BO class object
				bo.setCelebrityId(rs.getInt(1));  // here simple int value given by rs.getInt(1) is automatically converted into Integer wrapper obj by using autoboxing feature (java 5)
			   bo.setCelebrityName(rs.getString(2));
			   bo.setGender(rs.getString(3));
			   bo.setAge(rs.getInt(4));  //auto boxing
			   bo.setLastMovie(rs.getString(5));
			   bo.setCity(rs.getString(6));
			   //add each obj of BO class to List Collection
			   listBO.add(bo);
			//   listBO.forEach(System.out::println);
			}//while
		}//try
		catch(SQLException se) { //known exception
			se.printStackTrace();
			throw se;  //exception rethrowing..
		}
		catch(Exception e) {  //unknow exception
			e.printStackTrace();
			throw e;  //exeception rethrowing
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;  //exeception rethrowing
			}
		}//finally

		return listBO;
	}//getEmpsByDesgs(-,-,-)

}//class