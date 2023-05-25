package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDetailController {
	private final String command = "detail.br";
	private final String getPage = "boardDetailView";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(command)
	public String doAction(
				@RequestParam("pageNumber") int pageNumber, 
				@RequestParam("num") int num, 
				Model model) {
		
		boardDao.updateCount(num); // Á¶È¸¼ö
		BoardBean board = boardDao.getOneBoard(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
}
