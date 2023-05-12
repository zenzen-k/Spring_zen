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
	
	// �ٹ��ٿ� ��ü�� �ʿ��ϴ�.
	// �Ʊ� �ٿ�Ŭ�������� component�� �ڵ� ��ü ������ �߱� ������ Autowired ������̼��� ����Ͽ� ��ü����
	@Autowired
	//@Qualifier("myAlbumDao") -> ������ ����,,,�Ƚᵵ,,,����
	AlbumDao albumDao;
	
	// start.jsp ���� ��û��("list.ab") �Ѿ���°��� ����
	// ��Ϻ��⿡�� �˻��� ������ ���� ("list.ab") ��û�� �Ѵ�. (�̶��� ������ ������ ���� �Ѿ�´�.)
	
	// ������ ��ȣ Ŭ������ ���� ��û��.("list.ab") ���� Ŭ���� ������ ��ȣ�� ��������!
	// ��ó������(start.jsp) �� ������ ��ȣ�� �ѱ��� ������, �˻��Ҷ����� ������ ��ȣ�� �ѱ�� ���� �ƴϹǷ�  required = false
	
	
	/* 
	whatColumn �� keyword �� �Ѿ��
	
	whatColumn = title
	whatColumn = singer
	
	keyword = �Է��� ��. �˻��� ���� 
	keyword = ��
	keyword = ��
	 */
	
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			Model model, HttpServletRequest request) {
			// @RequestParam(value) �̷��� �����ϸ� �Ʒ��� ���� �ǹ�
			// @RequestParam(value = "whatColumn", required =true)
			// required true : �ݵ�� �Ѿ�;� �Ѵ� (�⺻��) 
			// required false : �ݵ�� �Ѿ�;� �ϴ°� �ƴԤ���
		
		
		System.out.println("whatColumn : " + whatColumn + " , keyword : " + keyword + " , pageNumber : " + pageNumber);
		
		/* �˻���� */
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); // whatColumn = null or whatColumn = title or singer // �÷����� ��
		map.put("keyword", "%" + keyword + "%"); // keyword = null or  keyword = �Է��� �� (%��%)
		
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount : " + totalCount);
		
		
		
		String url = request.getContextPath() + command;
		System.out.println("url : " + url); // url : /ex/list.ab
		
		// 7������ �޴� ������
		/*
		 pageNumber : ����������������
		 pageSize : ���������� ������ ���ڵ� ��
		 totalCount : ��ü ��������
		 url : ��������ȣ Ŭ���Ҷ����� list.jsp�� �������� list.ab
		 whatColumn : �˻��Ұ�
		 keyword : �˻�����
		 whologin : �������� �ʿ���� �� null
		 */
		
		// 3 -> null���ϰ� paging.java���� �����ںκп� if pageSize ="3" �̷��� ������ �ص� ������
		Paging pageInfo = new Paging(pageNumber, "3", totalCount, url, whatColumn, keyword, null);
		// �� ó������ pageNumber = null �̴�. ���� null�̸� 1������!
		
		
		/* ��� �ҷ����� */
		// getAllbumList() �޼��� ȣ���ؾ���
		List<AlbumBean> albumLists = albumDao.getAlbumList(pageInfo, map);
		// ���⼭ ȣ���ϸ� 
		
		// getPage �� albumLists�� ì�ܰ��� ���� �� �������� ���
		// model.addAttribute("albumLists", albumLists);
		// request.setAttribute("albumLists", albumLists);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists", albumLists);
		mav.addObject("pageInfo", pageInfo); // �����������Ѱ�
		mav.addObject("totalCount", totalCount); // ��ü����������
		
		mav.setViewName(getPage);
		
		return mav; // /WEB-INF/album/albumList.jsp -> ������ ���ϵѴ� ��������̱�
	}
}
