package game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import game.model.GameBean;
import game.model.GameDao;

@Controller
public class GameInsertController {
	
	private final String command = "insert.gm";
	private final String getPage = "gameInsertForm";
	private final String gotoPage = "redirect:/list.gm";
	
	@Autowired
	GameDao gameDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("game") @Valid GameBean game, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		} else {
			int cnt = gameDao.insertGame(game);
			if(cnt != -1) {
				mav.setViewName(gotoPage);
			}else {
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
