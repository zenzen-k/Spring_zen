package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {
	private final String command = "delete.mb";
	private final String gotoPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam("id") String id, 
			@RequestParam("pageNumber") String pageNumber,
			Model model) {
		model.addAttribute("pageNumber", pageNumber);
		int cnt = memberDao.deleteMember(id);
		if(cnt != -1)
			System.out.println("삭제성공");
		else
			System.out.println("삭제실패");
		return gotoPage;
	}
}
