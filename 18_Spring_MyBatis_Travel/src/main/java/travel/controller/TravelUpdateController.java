package travel.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TravelUpdateController {
	private final String command = "update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
}
