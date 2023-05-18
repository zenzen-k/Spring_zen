package game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import game.model.GameBean;
import game.model.GameDao;
import utility.Paging;

@Controller
public class GameListController {
	
	private final String command = "/list.gm";
	private final String getPage = "gameList";
	
	@Autowired
	GameDao gameDao;
	
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
		
		// 페이징
		int totalCount = gameDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, "3", totalCount, url, whatColumn, keyword, null);
		
		// 목록조회
		List<GameBean> lists = gameDao.getGameList(map, pageInfo);
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
	
}
