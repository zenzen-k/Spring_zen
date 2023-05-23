package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginContoller {
	private final String command = "loginForm.mb";
	private final String getPage = "memberLoginForm";
	
	@Autowired
	MemberDao memberDao;
	
	// ProductInsertContoller(insert.prd) - login ���� ������ �������� �´�.
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	//��ǰ�߰�Ŭ�� -> member\memberLoginForm.jsp ���� post ��û
//	@ResponseBody
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("id") String input_id,
			@RequestParam("password") String input_password,
			HttpServletResponse response,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		PrintWriter out = null;
		
		response.setContentType("text/html; charset=UTF-8");
		
		MemberBean mb = memberDao.getOneMember(input_id); // ȸ�������� ����
		System.out.println("mb:" + mb);
		
		if(mb == null) { // ���Ծ���
			System.out.println("�������� ���� ȸ��");
			
			try {
				out = response.getWriter();
				out.print("<script>alert('�ش� ���̵� �������� �ʽ��ϴ�');history.go(-1);</script>");
				out.flush(); // ���������� �������� �۾�
			}catch (IOException e) {
				
			}
			
			mav.setViewName(getPage);
			
		}else {
			System.out.println("������ ȸ��");
			
			if(mb.getPassword().equals(input_password)) {
				session.setAttribute("loginInfo", mb); // �α��� �� ������� ����
				
				//��ġ��. �α��� ����. ���� ������ ���� destination �� �Ǿ��մ�
				mav.setViewName((String)session.getAttribute("destination"));
			}else { // �������ߴµ� ��� ��ġ����
				try {
					out = response.getWriter();
					out.print("<script>alert('����� ��ġ���� �ʽ��ϴ�.');history.go(-1);</script>");
					out.flush(); // ���������� �������� �۾�
				}catch (IOException e) {
					
				}
				mav.setViewName(getPage);
			}//if(mb.getPassword().equals(input_password))
			
		} // if(mb == null) 
		
		return mav;
		
		
//		String msg = "";
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("password", input_password);
//		map.put("id", input_id);
//		int result = memberDao.loginMember(map);
//		
//		if(result == 0) {
//			msg = "<script>alert('fail : no id');location.href='loginForm.mb';</script>";
//		}else if(result == -2) {
//			msg = "<script>alert('fail : no password');location.href='loginForm.mb';</script>";
//		}else { // 1
//			msg = "";
//		}
//		return msg;
		
		
		
//		�ƴ� �̷��� ���
//		response.setContentType("text/html; charset=UTF-8");
//		String msg = "";
//		MemberBean mb = memberDao.getOneMember(input_id);
//		if(mb == null) {
//			msg = "<script>alert('�ش� ���̵� �������� �ʽ��ϴ�');history.go(-1);</script>";
//		}else {
//			if(mb.getPassword().equals(input_password)) {
//				msg = "";
//			}else {
//				msg = "<script>alert('����� ��ġ���� �ʽ��ϴ�.');history.go(-1);</script>";
//			}
//		}
//		return msg;
	}
}
