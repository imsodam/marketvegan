package com.util;

//게시판의 글내용을 출력할때 줄바꿈을 자동으로 인식해서 출력시켜주기 위해 필요
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}
