package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.CoronaCaseDTO;
import com.nt.service.CoronaCaseMgmtService;
import com.nt.vo.CoronaCaseVO;

public class MainController {
	private CoronaCaseMgmtService service;

	public MainController(CoronaCaseMgmtService service) {
		this.service = service;
	}

	public List<CoronaCaseVO> gatherCricketerByDesgs(String desg1, String desg2, String desg3) throws Exception {

		List<CoronaCaseDTO> listDTO = null;
		List<CoronaCaseVO> listVO = null;
		CoronaCaseVO vo = null;
		// use service
		listDTO = service.fetchCoronaCaseByDesgs(desg1, desg2, desg3);
		// convert listDTO to listVO
		listVO = new ArrayList();
		for (CoronaCaseDTO dto : listDTO) {
			// convert each dto to each vo
			vo = new CoronaCaseVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setStateNo(String.valueOf(dto.getStateNo()));
			vo.setPositive(String.valueOf(dto.getPositive()));
			vo.setRecovered(String.valueOf(dto.getRecovered()));
			vo.setActive(String.valueOf(dto.getActive()));
			vo.setDeath(String.valueOf(dto.getDeath()));
			// add each vo to listVO
			listVO.add(vo);
		} // for
		return listVO;
	} // method

}// class
