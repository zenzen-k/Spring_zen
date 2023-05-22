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
	
	// ServletContext 객체는 프로젝트당 하나가 만들어지며, 자동으로 생성된다.
	// 따라서 아래처럼 자동으로 생성된 객체를 주입하는 어노테이션을 작성함!
	@Autowired
	ServletContext servletContext;
	
	// 상품목록보기 -> 추가 클릭(로그인 정보 확인해야함)
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpSession session) { // 로그인을 위한 session 매개변수
		
		// 어디선가 로그인을 하면 로그인한 정보를 session(loginInfo)으로 설정함.
		System.out.println(session.getAttribute("loginInfo"));
		// 로그인 정보가 없다면 null 값이 나옴
		if(session.getAttribute("loginInfo") == null) { // 로그인 X
			return "redirect:/loginForm.mb"; 
			// MemberLoginContoller ->  memberLoginForm.jsp로 이동할것!. 
		}else { // 로그인 O
			return getPage;
		}
	}
	
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("product") @Valid ProductBean product,	BindingResult result){
		
		System.out.println("insert post");
		ModelAndView mav = new ModelAndView();
		
		// 이미지 파일을 저장할 위치(웹서버폴더)
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : " + uploadPath);
		
		// File 클래스 생성자에 문자열을 받을 수 있느 생성자가 있당
		// 위의 단순한 문자열을 폴더 개념으로 바꾸기 위해서는 File 객체를 생성함!
		// C:\\ ~ \resources\lemon.jpg 이렇게 파일이 올라가도록 한다
		File destination = new File(uploadPath + File.separator + product.getUpload().getOriginalFilename());
		// File destination = new File(uploadPath + "/" + product.getImage());
		// File.separator : 역슬래시 추가
		
		// 자동으로 만들어지는 객체는 아님,,,
		// Bean의 getUpload를 보면 MultipartFile 객체를 리턴하는 것을 볼 수 있당. 따라서 아래처럼 객체 생성
		MultipartFile multi = product.getUpload();
		
		if(result.hasErrors()) {
			System.out.println("유효성 검사 실패");
			mav.setViewName(getPage);
		}else {
			// 파일접근은 다르게 해야한다.
			int cnt = productDao.insertProduct(product);
			if(cnt != -1) {
				// DB 삽입 완료 후 파일을 올리는 작업
				// destination 위치에 파일을 올리게 되낟!!!!! 
				// IOException 예외 발생함
				try {
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				mav.setViewName(gotoPage);
			}else {
				System.out.println("삽입 실패 : " + cnt);
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
