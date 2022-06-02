package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.order.dao.OrderDAO;

public class CreateOrderNum {
	
	//6자리 랜덤 숫자 생성
	public static int generateAuthNo1() {
	    return ThreadLocalRandom.current().nextInt(100000, 1000000);
	}
	
	//주문번호 생성
	public String getOrderNum() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
		Date date=new Date();
		String today=sdf.format(date);
		String order_num="";
        int check=0;
        
       // do{
    		String random=Integer.toString(generateAuthNo1());
    		order_num=today+"-"+random;
            //check=orderDAO.orderNumCheck(order_num);
        //    System.out.println("주문번호중복체크(있으면 1)=>"+check);
       // }while(check==1);
        
        return order_num;
	}
}
