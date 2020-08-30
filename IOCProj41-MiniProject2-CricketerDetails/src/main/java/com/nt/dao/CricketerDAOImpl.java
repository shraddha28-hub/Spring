package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.CricketerBO;

public class CricketerDAOImpl implements CricketerDAO {
    private static final String GET_CRICKETER_BY_DESGS="SELECT CRICKETERID,CRICKETERNAME,AGE,ROLE,MATCHES,RUNS FROM CRICKETERDETAILS WHERE ROLE IN(?,?,?)";
	private DataSource ds;
	
	
	public CricketerDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public List<CricketerBO> getAllCricketerByDesgs(String desg1, String desg2, String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CricketerBO> listBO=null;
		CricketerBO bo=null;
		try {
			//get pooled jdbc connection
			con=ds.getConnection();
			//create preparedStatement object
			ps=con.prepareStatement(GET_CRICKETER_BY_DESGS);
			//set values to query params
			ps.setString(1,desg1); ps.setString(2,desg2); ps.setString(3, desg3);
			//execute the query
			rs=ps.executeQuery();
			//convert ResultSet object records to ListBO
			listBO=new ArrayList();
			while(rs.next()) {
				bo=new CricketerBO();
				//copy each record of ResultSet obj to BO class object
				bo.setCricketerId(rs.getInt(1));
				bo.setCricketerName(rs.getString(2));
				bo.setAge(rs.getInt(3));
				bo.setRole(rs.getString(4));
				bo.setMatches(rs.getInt(5));
				bo.setRuns(rs.getInt(6));
				
				 //add each obj of BO class to List Collection
				   listBO.add(bo);
			}
			
		}
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

