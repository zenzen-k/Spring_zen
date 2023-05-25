package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDeleteController {
	private final String command = "delete.br";
	private final String getPage = "boardDelete";
	private final String gotoPage = "redirect:/list.br";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
			@RequestParam("pageNumber") int pageNumber, 
			@RequestParam("num") int num) {
		
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(
			@RequestParam("pageNumber") int pageNumber, 
			@RequestParam("num") int num,
			@Valid BoardBean boardBean, BindingResult result, 
			HttpServletResponse response, Model model) {
		
		PrintWriter out = null;
		response.setContentType("text/html; charset=UTF-8");
		
		BoardBean board = boardDao.getOneBoard(num);
		if(result.hasErrors()) {
			return getPage;
		}else {

			System.out.println("원래 pw : " + board.getPasswd());
			System.out.println("입력 pw : " + boardBean.getPasswd());
			
			if(board.getPasswd().equals(boardBean.getPasswd())) {
				int cnt = boardDao.deleteBoard(num);
				System.out.println("delete cnt : " + cnt);
			}else {
				try {
					out = response.getWriter();
					out.print("<script>alert('비밀번호 잘못 입력함');history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			model.addAttribute("pageNumber", pageNumber);
			return gotoPage;
		}
		
	}
}
