package com.nt.vo;

import lombok.Data;

@Data
public class CoronaCaseVO {
	 private String serialNo;
     private String stateNo;
     private String stateName;
     private String positive;
     private String recovered;
     private String active;
     private String death;
}