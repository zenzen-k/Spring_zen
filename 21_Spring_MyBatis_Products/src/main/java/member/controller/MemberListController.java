package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController {
	private final String command = "/list.mb";
	private final String getPage = "memberList";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyword", "%"+keyword+"%");
		map.put("whatColumn", whatColumn);
		
		int totalCount = memberDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);
		
		List<MemberBean> lists = memberDao.getMemberList(map, pageInfo);
		
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		
		mav.setViewName(getPage);
		return mav;
	}
}
