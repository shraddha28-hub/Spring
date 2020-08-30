package com.nt.service;

import java.util.List;

import com.nt.dto.CricketerDTO;

public interface CricketerMgmtService {
	 public   List<CricketerDTO>  fetchCricketersByDesgs(String desg1,String desg2,String desg3)throws Exception;
}
