package album.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumListController {
	
	private final String command = "/list.ab";
	private final String getPage = "albumList";
	
	// �ٹ��ٿ� ��ü�� �ʿ��ϴ�.
	// �Ʊ� �ٿ�Ŭ�������� component�� �ڵ� ��ü ������ �߱� ������ Autowired ������̼��� ����Ͽ� ��ü����
	@Autowired
	//@Qualifier("myAlbumDao") -> ������ ����,,,�Ƚᵵ,,,����
	AlbumDao albumDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(Model model, HttpServletRequest request) {
		
		// getAllbumList() �޼��� ȣ���ؾ���
		List<AlbumBean> albumLists = albumDao.getAlbumList();
		// ���⼭ ȣ���ϸ� 
		
		// getPage �� albumLists�� ì�ܰ��� ���� �� �������� ���
		// model.addAttribute("albumLists", albumLists);
		// request.setAttribute("albumLists", albumLists);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumLists", albumLists);
		mav.setViewName(getPage);
		
		return mav; // /WEB-INF/album/albumList.jsp -> ������ ���ϵѴ� ��������̱�
	}
}
