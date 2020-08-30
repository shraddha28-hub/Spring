package com.nt.dto;

import lombok.Data;

@Data
public class CoronaCaseDTO {
	 private Integer serialNo;
     private Integer stateNo;
     private String stateName;
     private Integer positive;
     private Integer recovered;
     private Integer active;
     private Integer death;
}