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
			// ���������������� �̹��� ������ �ۼ���.
			// �Ǵ� ���� if��ó�� �ۼ��ص� ��!
			product.setImage(product.getUpload2());
			mav.setViewName(getPage);
		}else {
			//���������
			String uploadPath = servletContext.getRealPath("/resources");
			//���ε����ϰ��
			File destination = new File(uploadPath + "//" + product.getUpload().getOriginalFilename());
			//�������ϰ��
			File delFile = new File(uploadPath + File.separator + product.getUpload2());
			
			//�����۾�
			int cnt = productDao.updateProduct(product);
			
			if(cnt != -1) {
				// DB �۾� �Ϸ� �� �����̹��� �����, ���ο� �̹����� �÷����Ѵ�.
				//���ϰ�ü ����
				MultipartFile multi = product.getUpload();  
				try {
					//���Ͼ��ε� �۾�
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// ���ε� �� ���� ���� ����
				delFile.delete();
			} // if cnt
			mav.setViewName(gotoPage);
		}
		return mav;
	}
}
