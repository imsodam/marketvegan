package com.util;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class Static {
	//Strign  빈값체크
	public static boolean isStringEmpty(String str) {
		 return str == null || str.isEmpty();
	}
	
	//빈값체크
	//비어있는지
	public static Boolean empty(Object obj) {
		  if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
		  else if (obj instanceof List) return obj == null || ((List) obj).isEmpty();
		  else if (obj instanceof Map) return obj == null || ((Map) obj).isEmpty();
		  else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
		  else return obj == null;
		 }
		 
	//비어있지 않은지
	 public static Boolean notEmpty(Object obj) {
	  return !empty(obj);
	 }
	 
	 //<,>,(,)=>변경메서드
	 public static String convert(String name) {
		if(name!=null){
	    	//2.입력받은 문자열중에서 자바스크립트 구문을 실행시킬수 있는 특수기호를 입력X(<,>)
	    	//문자열메서드->replaceAll(1.변경전문자열,2.변경후 문자열)
	    	
	    	name=name.replaceAll("<","&lt");
	    	name=name.replaceAll(">","&gt");
	    	//추가 eval(" " or ' ')
	    	//name=name.replaceAll("\\(","&#40");
	    	//name=name.replaceAll("\\)","&#41");
	    	//"test"  'test'
	    	name=name.replaceAll("\"","&quot");
	    	name=name.replaceAll("\'","&apos");
	    }else{ //name==null
	    	return null; //입력을 하지 않았다면 더 이상 실행X
	    }
		return name;
	}
	
}
