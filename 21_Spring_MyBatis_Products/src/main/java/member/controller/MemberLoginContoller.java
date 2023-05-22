package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberLoginContoller {
	private final String command = "loginForm.mb";
	private final String getPage = "memberLoginForm";
	
	// ProductInsertContoller(insert.prd) - login ���� ������ �������� �´�.
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
}
