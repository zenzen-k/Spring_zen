package game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import game.model.GameDao;

@Controller
public class GameDeleteController {
	private final String command = "delete.gm";
	private final String gotoPage = "redirect:/list.gm";
	
	@Autowired
	GameDao gameDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		int cnt = gameDao.deleteGame(num);
		if(cnt == -1) {
			System.out.println("삭제실패");
		}
		model.addAttribute("pageNumber", pageNumber);
		return gotoPage;
	}
}
