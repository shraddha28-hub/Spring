package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.CoronaCaseBO;

public class CoronaCaseDAOImpl implements CoronaCaseDAO {
      private static final String GET_CORONACASEDETAILS_BY_STATE="SELECT * FROM CORONACASEDETAILS WHERE STATENAME IN(?,?,?)";
	private DataSource ds;
	
	public CoronaCaseDAOImpl(DataSource ds) {
			this.ds = ds;
	}

	@Override
	public List<CoronaCaseBO> getAllCoronaCaseByDesgs(String desg1, String desg2, String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CoronaCaseBO> listBO=null;
		CoronaCaseBO bo=null;
		try {
			//get pooled jdbc connection
			con=ds.getConnection();
			//create preparedStatement object
			ps=con.prepareStatement(GET_CORONACASEDETAILS_BY_STATE);
			//set values to query params
			ps.setString(1,desg1); ps.setString(2,desg2); ps.setString(3, desg3);
			//execute the query
			rs=ps.executeQuery();
			//convert ResultSet object records to ListBO
			listBO=new ArrayList();
			while(rs.next()) {
				bo=new CoronaCaseBO();
				//copy each record of ResultSet obj to BO class object
				bo.setStateNo(rs.getInt(1));
				bo.setStateName(rs.getString(2));
				bo.setPositive(rs.getInt(3));
				bo.setRecovered(rs.getInt(4));
				bo.setActive(rs.getInt(5));
				bo.setDeath(rs.getInt(6));
				
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


