package com.nt.bo;

import lombok.Data;

@Data
public class CoronaCaseBO {
     private Integer stateNo;
     private String stateName;
     private Integer positive;
     private Integer recovered;
     private Integer active;
     private Integer death;
}