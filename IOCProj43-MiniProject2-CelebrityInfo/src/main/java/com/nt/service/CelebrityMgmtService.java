package com.nt.service;

import java.util.List;

import com.nt.dto.CelebrityDTO;

public interface CelebrityMgmtService {
	public   List<CelebrityDTO>  fetchCelebrityByDesgs(String desg1,String desg2,String desg3)throws Exception;
}
