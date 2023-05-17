package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import movie.model.MovieDao;

@Controller
public class MovieDeleteController {
	
	private final String command = "delete.mv";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		int cnt = movieDao.deleteMovie(num);
		
		if(cnt == 1)
			System.out.println("��������");
		else
			System.out.println("��������");
		
		return gotoPage + "?pageNumber=" + pageNumber;
	}
}
