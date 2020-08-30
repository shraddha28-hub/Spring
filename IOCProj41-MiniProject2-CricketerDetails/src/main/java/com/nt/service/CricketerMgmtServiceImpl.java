package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CricketerBO;
import com.nt.dao.CricketerDAO;
import com.nt.dto.CricketerDTO;

public class CricketerMgmtServiceImpl implements CricketerMgmtService {
	private CricketerDAO dao;
        
	
	public CricketerMgmtServiceImpl(CricketerDAO dao) {
			super();
			this.dao = dao;
		}
	@Override
	public List<CricketerDTO> fetchCricketersByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<CricketerBO> listBO=null;
		List<CricketerDTO>  listDTO=null;
		CricketerDTO dto=null;
		//convert inputs(desgs) to uppercase letter  (b.logic)
	
		  desg1=desg1.toUpperCase(); 
		  desg2=desg2.toUpperCase();
		  desg3=desg3.toUpperCase();
		 
		//use DAO
		listBO=dao.getAllCricketerByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		  listDTO=new ArrayList();
		  for(CricketerBO bo: listBO) {
			  //copy each bo to new DTO object
			 dto=new CricketerDTO();
			 BeanUtils.copyProperties(bo, dto); // copies data from one javabean object to anthoer bean obj when they have matching properties names,types
			 dto.setSerialNo(listDTO.size()+1);  //serinal number generation..
			 //add each DTO 
			 listDTO.add(dto);
		  }//for

		return listDTO;
	}//method
}//class
		