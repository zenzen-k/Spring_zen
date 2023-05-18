package game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import game.model.GameDao;

@Controller
public class GameTitleCheckController {
	private final String command = "titleCheck.gm";
	
	@Autowired
	GameDao gameDao;
	
	@RequestMapping(command)
	@ResponseBody
	public String doAction(@RequestParam("inputTitle") String inputTitle) {
		boolean result = gameDao.gameTitleCheck(inputTitle);
		String data = null;
		if(result) {
			data = "N";
		}else {
			data = "Y";
		}
		return data;
	}
}
