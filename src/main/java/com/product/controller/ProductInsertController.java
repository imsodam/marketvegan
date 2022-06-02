package com.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.product.dao.ProductDAO;
import com.product.domain.ProductVO;
import com.util.FileUtil;


@Component
@Controller
public class ProductInsertController {
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private ProductDAO productDAO;	
	
	@RequestMapping("/admin/insertProduct.do")
	public String submit(@ModelAttribute("product") ProductVO product) {
		
		if(log.isDebugEnabled()) {
			//log.debug("ProductVO=>"+product);
			//log.debug("product_code=>"+product.getProduct_code());
		}
		
		List<MultipartFile> imgs=product.getUpload();
		String[] imgsName=new String[4];
		try {
			if(!product.getUpload().isEmpty()) {
				for(int i=0;i<imgs.size();i++) {
					MultipartFile img=imgs.get(i);
					if(img!=null && img.getOriginalFilename()!="") {
						String newName="";
						System.out.println("originalName=>"+img.getOriginalFilename());
						newName=FileUtil.rename(img.getOriginalFilename());
						System.out.println("newName=>"+newName);
						imgsName[i]=newName;//파일명 배열에 새이름 저장
						File file=new File(FileUtil.PRODUCT_UPLOAD_PATH+"\\"+newName);
						//물리적으로 데이터전송(파일 전송)
						img.transferTo(file);
					}
				}
				product.setProduct_img1(imgsName[1-1]);
				product.setProduct_img2(imgsName[2-1]);
				product.setProduct_img3(imgsName[3-1]);
				product.setProduct_img4(imgsName[4-1]);
			}
			if(product.getProduct_code()==0) {
				//새상품코드구하기
				int newCode=productDAO.getMaxCode()+1;
				product.setProduct_code(newCode);	
				System.out.println("인서트");
				//DB insert
				productDAO.insertProduct(product);
			}else {		
				//DB update//삭제할 레코드정보 가져오기
				ProductVO pv=null;
				pv=productDAO.getProduct(product.getProduct_code());
				System.out.println("업데이트");
				if(product.getProduct_img1()!=null) {
					FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img1());
				}
				if(product.getProduct_img2()!=null) {
					FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img2());
				}
				if(product.getProduct_img3()!=null) {
					FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img3());
				}
				if(product.getProduct_img4()!=null) {
					FileUtil.removeFile(FileUtil.PRODUCT_UPLOAD_PATH,pv.getProduct_img4());
				}
				productDAO.updateProduct(product);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}

		return "redirect:/admin/itemList.do";
	}
}
