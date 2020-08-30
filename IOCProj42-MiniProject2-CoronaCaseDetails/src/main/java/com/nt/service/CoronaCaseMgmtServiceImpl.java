package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CoronaCaseBO;
import com.nt.dao.CoronaCaseDAO;
import com.nt.dto.CoronaCaseDTO;

public class CoronaCaseMgmtServiceImpl implements CoronaCaseMgmtService {

	private CoronaCaseDAO dao;

	public CoronaCaseMgmtServiceImpl(CoronaCaseDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<CoronaCaseDTO> fetchCoronaCaseByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<CoronaCaseBO> listBO = null;
		List<CoronaCaseDTO> listDTO = null;
		CoronaCaseDTO dto = null;
		// convert inputs(desgs) to uppercase letter (b.logic)

		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();

		// use DAO
		listBO = dao.getAllCoronaCaseByDesgs(desg1, desg2, desg3);
		// convert listBO to listDTO
		listDTO = new ArrayList();
		for (CoronaCaseBO bo : listBO) {
			// copy each bo to new DTO object
			dto = new CoronaCaseDTO();
			BeanUtils.copyProperties(bo, dto); // copies data from one javabean object to anthoer bean obj when they
												// have matching properties names,types
			dto.setSerialNo(listDTO.size() + 1); // serinal number generation..
			// add each DTO
			listDTO.add(dto);
		} // for

		return listDTO;
	}// method
}// class
