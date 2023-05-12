package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	
	private final String command = "/list.ab";
	private final String getPage = "albumList";
	
	// 앨범다오 객체가 필요하다.
	// 아까 다오클래스에서 component로 자동 객체 생성을 했기 때문에 Autowired 어노테이션을 사용하여 객체만듬
	@Autowired
	//@Qualifier("myAlbumDao") -> ㅎ나라서 굳이,,,안써도,,,ㅇㅇ
	AlbumDao albumDao;
	
	// start.jsp 에서 요청함("list.ab") 넘어오는값이 없음
	// 목록보기에서 검색을 눌렀을 떄도 ("list.ab") 요청을 한다. (이때는 폼에서 선택한 값이 넘어온다.)
	
	// 페이지 번호 클릭했을 때도 요청함.("list.ab") 내가 클릭한 페이지 번호를 가지구감!
	// 맨처음에는(start.jsp) 등 페이지 번호를 넘기지 않으며, 검색할때에는 페이지 번호를 넘기는 것이 아니므로  required = false
	
	
	/* 
	whatColumn 과 keyword 가 넘어옴
	
	whatColumn = title
	whatColumn = singer
	
	keyword = 입력한 값. 검색할 ㅇㅇ 
	keyword = 마
	keyword = 이
	 */
	
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			Model model, HttpServletRequest request) {
			// @RequestParam(value) 이렇게 생략하면 아래와 같은 의미
			// @RequestParam(value = "whatColumn", required =true)
			// required true : 반드시 넘어와야 한다 (기본값) 
			// required false : 반드시 넘어와야 하는건 아님ㅇㅇ
		
		
		System.out.println("whatColumn : " + whatColumn + " , keyword : " + keyword + " , pageNumber : " + pageNumber);
		
		/* 검색기능 */
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); // whatColumn = null or whatColumn = title or singer // 컬럼명이 들어감
		map.put("keyword", "%" + keyword + "%"); // keyword = null or  keyword = 입력한 값 (%이%)
		
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount : " + totalCount);
		
		
		
		String url = request.getContextPath() + command;
		System.out.println("url : " + url); // url : /ex/list.ab
		
		// 7가지를 받는 생성자
		/*
		 pageNumber : 내가선택한페이지
		 pageSize : 한페이지에 보여줄 레코드 수
		 totalCount : 전체 페이지수
		 url : 페이지번호 클릭할때마다 list.jsp로 오기위한 list.ab
		 whatColumn : 검색할거
		 keyword : 검색내용
		 whologin : 마지막은 필요없음 걍 null
		 */
		
		// 3 -> null로하고 paging.java에서 생성자부분에 if pageSize ="3" 이렇게 선언을 해도 ㄱㅊ음
		Paging pageInfo = new Paging(pageNumber, "3", totalCount, url, whatColumn, keyword, null);
		// 맨 처음에는 pageNumber = null 이다. 따라서 null이면 1페이지!
		
		
		/* 목록 불러오기 */
		// getAllbumList() 메서드 호출해야함
		List<AlbumBean> albumLists = albumDao.getAlbumList(pageInfo, map);
		// 여기서 호출하면 
		
		// getPage 로 albumLists를 챙겨가고 싶을 때 여러가지 방법
		// model.addAttribute("albumLists", albumLists);
		// request.setAttribute("albumLists", albumLists);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists", albumLists);
		mav.addObject("pageInfo", pageInfo); // 페이지설정한거
		mav.addObject("totalCount", totalCount); // 전체페이지설정
		
		mav.setViewName(getPage);
		
		return mav; // /WEB-INF/album/albumList.jsp -> 폴더랑 파일둘다 생서앻쥬ㅜ기
	}
}
