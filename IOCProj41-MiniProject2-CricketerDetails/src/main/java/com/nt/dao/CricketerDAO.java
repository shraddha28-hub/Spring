package com.nt.dao;

import java.util.List;

import com.nt.bo.CricketerBO;


public interface CricketerDAO {
	 public  List<CricketerBO> getAllCricketerByDesgs(String desg1,String desg2,String desg3)throws Exception;
}
