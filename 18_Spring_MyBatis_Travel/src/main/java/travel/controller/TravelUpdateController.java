package travel.controller;

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

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {
	private final String command = "update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction(
			@RequestParam("num") int num, 
			@RequestParam("pageNumber") int pageNumber, 
			Model model) {
		
		TravelBean travel = travelDao.getTravelByNum(num);
		model.addAttribute("travel", travel);
		model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@ModelAttribute("travel") @Valid TravelBean travel, 
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		//System.out.println("num : " + travel.getNum());
		//System.out.println("name : " + travel.getName());
		
		if(result.hasErrors()) {
			//System.out.println("�����߻�");
			mav.setViewName(getPage);
		} else {
			int cnt = travelDao.updateTravel(travel);
			//System.out.println("cnt : " + cnt);
			
			if(cnt == 1) {
				mav.setViewName(gotoPage);
				// �Ʒ�ó�� �Ķ���ͷ� �Ѱܵ� �ȴ�.
				//mvc.setViewName(gotoPage + "?pageNumber=" + pageNumber);
			}else {
				System.out.println("������Ʈ����");
				//mav.setViewName(getPage);
				mav.addObject("pageNumber", pageNumber);
				mav.addObject("num", travel.getNum());
				mav.setViewName("redirect:/"+command);
			}
		}
		return mav;
	}
}
