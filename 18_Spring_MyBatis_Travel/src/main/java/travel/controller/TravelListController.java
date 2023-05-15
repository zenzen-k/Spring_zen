package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	private final String command = "/list.tv"; // 요청이름
	private final String getPage = "travelList"; // return 값. 넘어갈 페이지
	// /WEB-INF/travel/travelList.jsp
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(
			// 어노테이션안의 value는 jsp에서 설정했던 name과 반드시 같아야 하지만 그 옆에 String 변수명은 암거나 ㄱㅊ
			// 또는 Model model, HttpServletRequest request 로 받아도 된다.
			@RequestParam(value = "whatColumn", required = false)  String whatColumn,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			// pageNumber 는 대소문자 구분해서 이대로 작성
			HttpServletRequest request
			) {
		
		// 검색
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); 
		// put의 값의 이름(왼쪽)은 아무거나 설정해도 된다. 대신 그러면 xml에서 해당 변수명을 써줘야할득? 
		map.put("keyword", "%" + keyword + "%"); //%마%, %유%, %한국%
		// 넘어온 값이 없다면 null 이 들어감~
		
		
		int totalCount = travelDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		// Paging(String _pageNumber, String _pageSize, int totalCount, String url, String whatColumn, String keyword, String whologin)
		// 페이지
		Paging pageInfo = new Paging(pageNumber, "3", totalCount, url, whatColumn, keyword, null);
		// pageNumber 가 null 이면 무조건 1이 들어가도록 Paging에 이런저런 설정이 되어있당.
		// "3"이 아닌 null을 넘기면 기본값 3으로 되어있음!!!
		
		
		// 목록불러오기
		List<TravelBean> lists = travelDao.getAllTravel(pageInfo, map); // pageInfo : 내가 선택한 페이지 번호
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
