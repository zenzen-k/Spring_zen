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
	
	// ProductInsertContoller(insert.prd) - login 세션 없을때 이쪽으로 온다.
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	//상품추가클릭 -> member\memberLoginForm.jsp 에서 post 요청
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
		
		MemberBean mb = memberDao.getOneMember(input_id); // 회원정보가 있음
		System.out.println("mb:" + mb);
		
		if(mb == null) { // 가입안함
			System.out.println("가입하지 않은 회원");
			
			try {
				out = response.getWriter();
				out.print("<script>alert('해당 아이디가 존재하지 않습니다');history.go(-1);</script>");
				out.flush(); // 웹브라우저에 내보내는 작업
			}catch (IOException e) {
				
			}
			
			mav.setViewName(getPage);
			
		}else {
			System.out.println("가입한 회원");
			
			if(mb.getPassword().equals(input_password)) {
				session.setAttribute("loginInfo", mb); // 로그인 한 사용자의 정보
				
				//일치함. 로그인 ㄱㄱ. 원래 가려던 곳은 destination 에 되어잇다
				mav.setViewName((String)session.getAttribute("destination"));
			}else { // 가입은했는데 비번 일치안함
				try {
					out = response.getWriter();
					out.print("<script>alert('비번이 일치하지 않습니다.');history.go(-1);</script>");
					out.flush(); // 웹브라우저에 내보내는 작업
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
		
		
		
//		아님 이런건 어떨까
//		response.setContentType("text/html; charset=UTF-8");
//		String msg = "";
//		MemberBean mb = memberDao.getOneMember(input_id);
//		if(mb == null) {
//			msg = "<script>alert('해당 아이디가 존재하지 않습니다');history.go(-1);</script>";
//		}else {
//			if(mb.getPassword().equals(input_password)) {
//				msg = "";
//			}else {
//				msg = "<script>alert('비번이 일치하지 않습니다.');history.go(-1);</script>";
//			}
//		}
//		return msg;
	}
}
