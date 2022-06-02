package com.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cart.dao.CartDAO;
import com.order.domain.CartVO;
import com.util.LoginId;

@Component
@Controller
public class GoCartController {
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping("/goCart.do")
	public String goCart(@RequestParam(value="product_code") int product_code,
								@RequestParam(value="count") int count,
								HttpServletRequest request
			){
		/*String user_id="";
	    HttpSession session = request.getSession(false);
	    if(session!=null) {
	    	user_id=(String)session.getAttribute("idKey");
	    }*/
	    LoginId id=new LoginId(request);
	    String user_id=id.getId();	    
		
	    if(log.isDebugEnabled()) {
			//log.debug("user_id=>"+user_id);
		}
	    
	    //넘겨줄 cart정보 담기
	    CartVO cart=new CartVO();
	    cart.setCart_count(count);
	    cart.setProduct_code(product_code);
	    cart.setUser_id(user_id);
	    
	    //장바구니에 해당상품 있는지 조회
	    int inCartCount=cartDAO.selectCartProduct(cart);
	    
	    if(inCartCount==0) {//해당상품 없으면 새로 넣기
	    	cartDAO.insertCart(cart);
	    }
	    if(inCartCount>0) {//해당상품 있으면 수량구해와서 수량 변경
	    	//해당상품 기존 수량
	    	int oldCount=cartDAO.selectCountCart(cart);
	    	//수량변경
		    cart.setCart_count(oldCount+count);
		    cartDAO.updateCountCart(cart);
	    }
	   
		
		return "/order/go_cart";
	}
}
