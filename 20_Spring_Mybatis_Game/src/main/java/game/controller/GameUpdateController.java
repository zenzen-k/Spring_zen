package game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import game.model.GameBean;
import game.model.GameDao;

@Controller
public class GameUpdateController {
	private final String command = "update.gm";
	private final String getPage = "gameUpdateForm";
	private final String gotoPage = "redirect:/list.gm";
	
	@Autowired
	GameDao gameDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber) {
		GameBean game = gameDao.getOneGame(num);
		ModelAndView mav = new ModelAndView();
		mav.addObject("game", game);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("game") @Valid GameBean game, 
			BindingResult result, 
			@RequestParam("pageNumber") int pageNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = gameDao.updateGame(game);
			if(cnt != -1) {
				mav.setViewName(gotoPage);
			}else {
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
