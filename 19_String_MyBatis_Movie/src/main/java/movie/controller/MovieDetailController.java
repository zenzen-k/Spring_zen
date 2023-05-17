package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieDetailController {
	private final String command = "detail.mv";
	private final String getPage = "movieDetailView";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		
		MovieBean movie = movieDao.getOneMovie(num);
		
		mav.addObject("movie", movie);
		
		// �ڵ����� ���� view jsp���� �Ķ���� ���� �Ѿ�� ������ ���� �ۼ������� �ʾƵ� 
		// ���� jsp ���� param.pageNumber �� ������ �ȴ�~
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
}
