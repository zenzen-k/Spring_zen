package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	
	private final String command = "/delete.prd";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		ProductBean pb = productDao.getOneProduct(num);
		
		int cnt = productDao.deleteProduct(num);
		mav.setViewName(gotoPage);
		if(cnt != -1) {
			System.out.println("삭제성공");
			
			
			String deletePath = servletContext.getRealPath("/resources");
			// 이미지 파일 경로
			File prdImage = new File(deletePath + File.separator + pb.getImage());
			boolean flag = prdImage.delete();
			if(flag) {
				System.out.println("이미지 삭제 성공");
			}else {
				System.out.println("이미지 삭제 실패");
			}
		}
		else{
			System.out.println("삭제실패");
		}
		return mav;
	}
}
