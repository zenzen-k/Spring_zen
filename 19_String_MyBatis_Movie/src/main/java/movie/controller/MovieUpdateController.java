package movie.controller;

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

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieUpdateController {
	
	private final String command = "update.mv";
	private final String getPage = "movieUpdateForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		
		MovieBean movie = movieDao.getOneMovie(num);
		model.addAttribute("movie", movie);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@ModelAttribute("movie") @Valid MovieBean movie, 
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = movieDao.updateMovie(movie);
			
			if(cnt != -1) { // ����
				mav.setViewName(gotoPage);
			}else { // ����
				mav.setViewName(getPage);
			}
		}
		
		return mav;
	}
}
