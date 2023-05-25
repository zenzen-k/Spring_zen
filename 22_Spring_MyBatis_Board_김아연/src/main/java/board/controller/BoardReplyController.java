package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardReplyController {
	private final String command = "reply.br";
	private final String getPage = "boardReplyForm";
	private final String gotoPage = "redirect:/list.br";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(HttpServletRequest request, Model model) {
		String pageNumber = request.getParameter("pageNumber");
		String ref = request.getParameter("ref");
		String restep = request.getParameter("restep");
		String relevel = request.getParameter("relevel");
		
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("ref",ref);
		model.addAttribute("restep",restep);
		model.addAttribute("relevel",relevel);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@ModelAttribute("board") @Valid BoardBean board, 
			BindingResult result, HttpServletRequest request) {
		System.out.println("boardReply");
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			// 수정작업 먼저
			int cnt = boardDao.replyUpdateBoard(board);
			System.out.println("reup cnt : " + cnt);
			
			if(cnt != -1) {
				board.setRestep(board.getRestep()+1);
				board.setRelevel(board.getRelevel()+1);
				board.setIp(request.getRemoteAddr());
				
				boardDao.replyInsertBoard(board);
				
				mav.setViewName(gotoPage);
			}else {
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
