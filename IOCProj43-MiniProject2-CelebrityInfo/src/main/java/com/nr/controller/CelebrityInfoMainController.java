package com.nr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.CelebrityDTO;
import com.nt.service.CelebrityMgmtService;
import com.nt.vo.CelebrityVO;

public class CelebrityInfoMainController {

	private CelebrityMgmtService service;

	public CelebrityInfoMainController(CelebrityMgmtService service) {
		this.service = service;
	}

	public List<CelebrityVO> gatherCelebrityByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<CelebrityDTO> listDTO = null;
		List<CelebrityVO> listVO = null;
		CelebrityVO vo = null;
		// use service
		listDTO = service.fetchCelebrityByDesgs(desg1, desg2, desg3);
		// convert listDTO to listVO
		listVO = new ArrayList();
		for (CelebrityDTO dto : listDTO) {
			// convert each dto to each vo
			vo = new CelebrityVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSerialNo(String.valueOf(dto.getSerialNo()));
			vo.setCelebrityId(String.valueOf(dto.getCelebrityId()));
			vo.setAge(String.valueOf(dto.getAge()));
			// add each vo to listVO
			listVO.add(vo);
		} // for
		return listVO;
	} // method

}// class
