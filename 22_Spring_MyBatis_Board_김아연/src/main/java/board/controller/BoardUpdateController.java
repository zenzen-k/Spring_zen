package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
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
public class BoardUpdateController {
	private final String command = "update.br";
	private final String getPage = "boardUpdateForm";
	private final String gotoPage = "redirect:/list.br";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
			@RequestParam("pageNumber") int pageNumber, 
			@RequestParam("num") int num, 
			Model model) {
		
		BoardBean board = boardDao.getOneBoard(num);
		model.addAttribute("board", board);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber, 
			@ModelAttribute("board") @Valid BoardBean board,
			BindingResult result, HttpServletResponse response
			
			) {
		ModelAndView mav = new ModelAndView();
		PrintWriter out = null;
		response.setContentType("text/html; charset=UTF-8");
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			BoardBean bb = boardDao.getOneBoard(board.getNum());
			
			System.out.println("원래 pw : " + bb.getPasswd());
			System.out.println("입력 pw : " + board.getPasswd());
			if(bb.getPasswd().equals(board.getPasswd())) {
				int cnt = boardDao.updateBoard(board);
				System.out.println("update cnt : " + cnt);
				
				mav.addObject("pageNumber", pageNumber);
				mav.setViewName(gotoPage);
			}else {
				try {
					out = response.getWriter();
					out.print("<script>alert('비밀번호 잘못 입력');history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
