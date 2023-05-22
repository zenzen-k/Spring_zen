package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	// ServletContext ��ü�� ������Ʈ�� �ϳ��� ���������, �ڵ����� �����ȴ�.
	// ���� �Ʒ�ó�� �ڵ����� ������ ��ü�� �����ϴ� ������̼��� �ۼ���!
	@Autowired
	ServletContext servletContext;
	
	// ��ǰ��Ϻ��� -> �߰� Ŭ��(�α��� ���� Ȯ���ؾ���)
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) { // �α����� ���� session �Ű�����
		
		// ��𼱰� �α����� �ϸ� �α����� ������ session(loginInfo)���� ������.
		System.out.println(session.getAttribute("loginInfo"));
		// �α��� ������ ���ٸ� null ���� ����
		if(session.getAttribute("loginInfo") == null) { // �α��� X
			return "redirect:/loginForm.mb"; 
			// MemberLoginContoller ->  memberLoginForm.jsp�� �̵��Ұ�!. 
		}else { // �α��� O
			return getPage;
		}
	}
	
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("product") @Valid ProductBean product,	BindingResult result){
		
		System.out.println("insert post");
		ModelAndView mav = new ModelAndView();
		
		// �̹��� ������ ������ ��ġ(����������)
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : " + uploadPath);
		
		// File Ŭ���� �����ڿ� ���ڿ��� ���� �� �ִ� �����ڰ� �ִ�
		// ���� �ܼ��� ���ڿ��� ���� �������� �ٲٱ� ���ؼ��� File ��ü�� ������!
		// C:\\ ~ \resources\lemon.jpg �̷��� ������ �ö󰡵��� �Ѵ�
		File destination = new File(uploadPath + File.separator + product.getUpload().getOriginalFilename());
		// File destination = new File(uploadPath + "/" + product.getImage());
		// File.separator : �������� �߰�
		
		// �ڵ����� ��������� ��ü�� �ƴ�,,,
		// Bean�� getUpload�� ���� MultipartFile ��ü�� �����ϴ� ���� �� �� �ִ�. ���� �Ʒ�ó�� ��ü ����
		MultipartFile multi = product.getUpload();
		
		if(result.hasErrors()) {
			System.out.println("��ȿ�� �˻� ����");
			mav.setViewName(getPage);
		}else {
			// ���������� �ٸ��� �ؾ��Ѵ�.
			int cnt = productDao.insertProduct(product);
			if(cnt != -1) {
				// DB ���� �Ϸ� �� ������ �ø��� �۾�
				// destination ��ġ�� ������ �ø��� �ǳ�!!!!! 
				// IOException ���� �߻���
				try {
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				mav.setViewName(gotoPage);
			}else {
				System.out.println("���� ���� : " + cnt);
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
