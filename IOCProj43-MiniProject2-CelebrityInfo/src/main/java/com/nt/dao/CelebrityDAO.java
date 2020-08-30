package com.nt.dao;

import java.util.List;

import com.nt.bo.CelebrityBO;

public interface CelebrityDAO {
	public List<CelebrityBO> getAllCelebrityByDesgs(String desg1, String desg2, String desg3) throws Exception;
}
