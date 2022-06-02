package com.product.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.dao.ProductDAO;
import com.product.domain.ProductVO;
import com.util.FileUtil;

@Component
@Controller
public class ProductDeleteController {
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private ProductDAO productDAO;	
	
	@RequestMapping("/admin/deleteProduct.do")
	public String submit(@ModelAttribute("product") ProductVO product) {
		System.out.println("DeleteController 호출됨! 삭제할 코드는?"+product.getProduct_code());
		
		if(log.isDebugEnabled()) {
			log.debug("ProductVO=>"+product);
		}
		
		//삭제할 레코드정보 가져오기
		ProductVO pv=null;
		pv=productDAO.getProduct(product.getProduct_code());
		
		//테이블에서 레코드 삭제
		productDAO.deleteProduct(product.getProduct_code());
		
		//파일삭제
		System.out.println("삭제할 파일명");
		System.out.println(pv.getProduct_img1());
		System.out.println(pv.getProduct_img2());
		System.out.println(pv.getProduct_img3());
		System.out.println(pv.getProduct_img4());
		if(pv.getProduct_img1()!=null) {
			FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img1());
		}
		if(pv.getProduct_img2()!=null) {
			FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img2());
		}
		if(pv.getProduct_img3()!=null) {
			FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img3());
		}
		if(pv.getProduct_img4()!=null) {
			FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img4());
		}
		
		return "redirect:/admin/itemList.do";
	}
	
}
