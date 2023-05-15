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
	
	private final String command = "/list.tv"; // ��û�̸�
	private final String getPage = "travelList"; // return ��. �Ѿ ������
	// /WEB-INF/travel/travelList.jsp
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(
			// ������̼Ǿ��� value�� jsp���� �����ߴ� name�� �ݵ�� ���ƾ� ������ �� ���� String �������� �ϰų� ����
			// �Ǵ� Model model, HttpServletRequest request �� �޾Ƶ� �ȴ�.
			@RequestParam(value = "whatColumn", required = false)  String whatColumn,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			// pageNumber �� ��ҹ��� �����ؼ� �̴�� �ۼ�
			HttpServletRequest request
			) {
		
		// �˻�
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); 
		// put�� ���� �̸�(����)�� �ƹ��ų� �����ص� �ȴ�. ��� �׷��� xml���� �ش� �������� ������ҵ�? 
		map.put("keyword", "%" + keyword + "%"); //%��%, %��%, %�ѱ�%
		// �Ѿ�� ���� ���ٸ� null �� ��~
		
		
		int totalCount = travelDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		
		// Paging(String _pageNumber, String _pageSize, int totalCount, String url, String whatColumn, String keyword, String whologin)
		// ������
		Paging pageInfo = new Paging(pageNumber, "3", totalCount, url, whatColumn, keyword, null);
		// pageNumber �� null �̸� ������ 1�� ������ Paging�� �̷����� ������ �Ǿ��ִ�.
		// "3"�� �ƴ� null�� �ѱ�� �⺻�� 3���� �Ǿ�����!!!
		
		
		// ��Ϻҷ�����
		List<TravelBean> lists = travelDao.getAllTravel(pageInfo, map); // pageInfo : ���� ������ ������ ��ȣ
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
