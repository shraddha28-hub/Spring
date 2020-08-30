package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.CricketerDTO;
import com.nt.service.CricketerMgmtService;
import com.nt.vo.CricketerVO;

public class MainController {
	private CricketerMgmtService service;

	public MainController(CricketerMgmtService service) {
		this.service = service;
	}

	public  List<CricketerVO> gatherCricketerByDesgs(String desg1,String desg2,String desg3)throws Exception{
		
		List<CricketerDTO> listDTO=null;
		List<CricketerVO> listVO=null;
		CricketerVO vo=null;
		//use service
		  listDTO=service.fetchCricketersByDesgs(desg1, desg2, desg3);
		  //convert listDTO to listVO
		  listVO=new ArrayList();
		  for(CricketerDTO dto:listDTO) {
			  //convert each dto to each vo
                  vo=new CricketerVO();
                  BeanUtils.copyProperties(dto, vo);
                  vo.setSerialNo(String.valueOf(dto.getSerialNo()));
                  vo.setMatches(String.valueOf(dto.getMatches()));
                 vo.setRuns(String.valueOf(dto.getRuns()));
                  vo.setCricketerId(String.valueOf(dto.getCricketerId()));
                  vo.setAge(String.valueOf(dto.getAge()));
                  //add each vo to listVO
                  listVO.add(vo);
		  }//for
		  return listVO;
	} //method


}//class

