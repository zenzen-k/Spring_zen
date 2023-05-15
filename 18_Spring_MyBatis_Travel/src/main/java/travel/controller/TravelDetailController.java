package travel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelDetailController {
	private final String command = "detail.tv";
	private final String getPage = "travelDetailView";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num, Model model) {
		TravelBean travel = travelDao.getTravelByNum(num);
		model.addAttribute("travel", travel);
		return getPage;
	}
}
