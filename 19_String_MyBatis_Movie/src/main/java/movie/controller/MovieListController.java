package movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;

@Controller
public class MovieListController {
	
	private final String command = "/list.mv";
	private final String getPage = "movieList";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		
		// 검색
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%" + keyword + "%");
		
		System.out.println("whatColumn : " + whatColumn);
		System.out.println("keyword : " + keyword);
		
		// 페이징
		int totalCount = movieDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, "2", totalCount, url, whatColumn, keyword, null);
		
		// 목록
		List<MovieBean> list = movieDao.getMovieList(pageInfo, map);
		
		//속성
		mav.addObject("list", list);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage); // WEB-INF\movie\movieList.jsp
		
		return mav;
	}
}
