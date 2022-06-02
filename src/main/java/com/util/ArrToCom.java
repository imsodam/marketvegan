package com.util;

import java.util.List;

//배열을 컴마로 바꿔주기
//sql in()에 넣기위함
public class ArrToCom {
	private String comString="";
	
	public ArrToCom(String[] numArr) {
		for(String num : numArr) {
			comString+="'"+num+"',";
		}
		comString=comString.replaceAll(",$", "");
	}
	public ArrToCom(List<Integer> numArr) {
		for(Integer num : numArr) {
			comString+=num+",";
		}
		comString=comString.replaceAll(",$", "");
	}
	public String getComString() {
		return comString;
	}
}
