package member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {
	private final String command = "update.mb";
	private final String getPage = "memberUpdateForm";
	private final String gotoPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	// memberList.jsp ���� id, pageNumber �� ����
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("id") String id,
			@RequestParam("pageNumber") String pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		MemberBean member = memberDao.getOneMember(id);
		mav.addObject("member", member);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	// memberUpdateForm.jsp ���� �Ѿ��
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") String pageNumber,
			@ModelAttribute("member") @Valid MemberBean member,
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = memberDao.updateMember(member);
			if(cnt != -1) {
				mav.setViewName(gotoPage);
			}else {
				mav.setViewName(getPage);
			}
		}
		
		return mav;
	}
}
