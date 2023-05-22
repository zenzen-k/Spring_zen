package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
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
public class ProductUpdateController {
	private final String command = "/update.prd";
	private final String getPage = "ProductUpdateForm";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		ProductBean product = productDao.getOneProduct(num);
		mav.addObject("product", product);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("product") @Valid ProductBean product,
			BindingResult result,
			@RequestParam("pageNumber") int pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
//		if(product.getImage().equals("")) {
//			product.setImage(product.getUpload2());
//		}
		if(result.hasErrors()) {
			// 수정실패했을때도 이미지 띄우려고 작성함.
			// 또는 위에 if문처럼 작성해도 됨!
			product.setImage(product.getUpload2());
			mav.setViewName(getPage);
		}else {
			//웹서버경로
			String uploadPath = servletContext.getRealPath("/resources");
			//업로드파일경로
			File destination = new File(uploadPath + "//" + product.getUpload().getOriginalFilename());
			//삭제파일경로
			File delFile = new File(uploadPath + File.separator + product.getUpload2());
			
			//수정작업
			int cnt = productDao.updateProduct(product);
			
			if(cnt != -1) {
				// DB 작업 완료 후 원래이미지 지우고, 새로운 이미지를 올려야한다.
				//파일객체 주입
				MultipartFile multi = product.getUpload();  
				try {
					//파일업로드 작업
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 업로드 후 원래 파일 삭제
				delFile.delete();
			} // if cnt
			mav.setViewName(gotoPage);
		}
		return mav;
	}
}
