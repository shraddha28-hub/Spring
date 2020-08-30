package com.nt.dao;

import java.util.List;

import com.nt.bo.CoronaCaseBO;

public interface CoronaCaseDAO {
	public List<CoronaCaseBO> getAllCoronaCaseByDesgs(String desg1, String desg2, String desg3) throws Exception;
}
