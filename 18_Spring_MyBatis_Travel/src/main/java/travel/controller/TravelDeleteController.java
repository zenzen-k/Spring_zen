package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {
	private final String command = "delete.tv";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber) {
		int cnt = travelDao.deleteTravel(num);
		if(cnt == 1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		return gotoPage + "?pageNumber=" + pageNumber;
	}
	
}
