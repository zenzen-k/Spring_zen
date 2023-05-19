package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductInsertContoller {
	private final String command = "/insert.prd";
	private final String getPage = "productInsertForm";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("product") @Valid ProductBean product,
			BindingResult result,
			HttpServletRequest request,
			@RequestParam("image") MultipartFile image) throws Exception {
		System.out.println("insert post");
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println("유효성 검사 실패");
			mav.setViewName(getPage);
		}else {
			String fileDir = request.getContextPath() + "/images/";
			image.transferTo(new File(fileDir + image.getOriginalFilename()));
			
			int cnt = productDao.insertProduct(product);
			if(cnt != -1) {
				mav.setViewName(gotoPage);
			}else {
				System.out.println("삽입 실패 : " + cnt);
				mav.setViewName(getPage);
			}
		}
		
		return mav;
	}
}
