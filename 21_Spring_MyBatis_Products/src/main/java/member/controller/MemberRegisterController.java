package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {
	private final String command = "registerForm.mb";
	private final String getPage = "memberRegisterForm";
	private final String gotoPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	// memberLoginForm.jsp ���� ȸ������ Ŭ��(registerForm.mb ��û)
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	// memberRegisterForm.jsp ���� register.mb ��û��
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("member") @Valid MemberBean member, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		
		if(result.hasErrors()) {
			System.out.println("hasError");
			mav.setViewName(getPage);
		}else {
			int cnt = memberDao.insertMember(member);
			if(cnt != -1)
				mav.setViewName(gotoPage);
			else
				mav.setViewName(getPage);
		}
		return mav;
	}
}
