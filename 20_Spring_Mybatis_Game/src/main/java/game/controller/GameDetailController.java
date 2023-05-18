package game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import game.model.GameBean;
import game.model.GameDao;

@Controller
public class GameDetailController {
	private final String command = "detail.gm";
	private final String getPage = "gameDetailView";
	
	@Autowired
	GameDao gameDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		GameBean game = gameDao.getOneGame(num);
		model.addAttribute("game", game);
		return getPage;
	}
}
