package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CelebrityBO;
import com.nt.dao.CelebrityDAO;
import com.nt.dto.CelebrityDTO;

public class CelebrityMgmtServiceImpl implements CelebrityMgmtService {

	private CelebrityDAO dao;
	
	
	public CelebrityMgmtServiceImpl(CelebrityDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<CelebrityDTO> fetchCelebrityByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<CelebrityBO> listBO=null;
		List<CelebrityDTO>  listDTO=null;
		CelebrityDTO dto=null;
		//convert inputs(desgs) to uppercase letter  (b.logic)
		
		
		 desg1=desg1.toUpperCase(); desg2=desg2.toUpperCase();
		 desg3=desg3.toUpperCase();
		
		//use DAO
		listBO=dao.getAllCelebrityByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		  listDTO=new ArrayList();
		  for(CelebrityBO bo: listBO) {
			  //copy each bo to new DTO object
			 dto=new CelebrityDTO();
			 BeanUtils.copyProperties(bo, dto); // copies data from one javabean object to anthoer bean obj when they have matching properties names,types
			 dto.setSerialNo(listDTO.size()+1);  //serinal number generation..
			 //add each DTO 
			 listDTO.add(dto);
		  }//for

		return listDTO;
	}//method
}//class