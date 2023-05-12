package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {
	
	private final String command = "update.ab";
	private final String getPage = "albumUpdateForm";
	private final String gotoPage = "redirect:/list";
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num, Model model) {
		AlbumBean album = albumDao.getAlbumByNum(num);
		model.addAttribute("album", album);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result) {
		// ModelAndView 를 사용하려면?
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = albumDao.updateAlbum(album);
			
			if(cnt != -1) {
				mav.setViewName(gotoPage);
			} else { // 수정실패
				System.out.println("실패 cnt" + cnt);
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
	
}
