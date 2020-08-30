package com.nt.service;

import java.util.List;

import com.nt.dto.CoronaCaseDTO;


public interface CoronaCaseMgmtService {
	 public   List<CoronaCaseDTO>  fetchCoronaCaseByDesgs(String desg1,String desg2,String desg3)throws Exception;
}
