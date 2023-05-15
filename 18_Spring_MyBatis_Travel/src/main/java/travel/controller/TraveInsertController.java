package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TraveInsertController {
	private final String command = "insert.tv";
	private final String getPage = "travelInsertForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao travelDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(@ModelAttribute("travel") @Valid TravelBean travelBean, BindingResult result) {
	// �� �Ӽ����� ���ϸ� travelBean
		
		if(result.hasErrors()) {
			return getPage;
		} else {
			int cnt = travelDao.insertTravel(travelBean);
			if(cnt == 1) { // ���Լ���
				return gotoPage;
			}else {
				return getPage;
			}
		}
	}
}
