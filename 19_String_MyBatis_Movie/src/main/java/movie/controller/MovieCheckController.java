package movie.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.model.MovieDao;

@Controller
public class MovieCheckController {
	
	private final String command = "/title_check_proc.mv";
	
	@Autowired
	MovieDao movieDao;
	
	@RequestMapping(command)
	@ResponseBody
	public String doAction(@RequestParam("title") String title, HttpServletResponse response) {
		System.out.println("title_check_proc.mv");
		boolean result = movieDao.searchTitle(title);
		
		if(result)  // 참 : 제목이미있음, 사용못함
			//response.getWriter().append("N");
			return "N"; // 문자열을 바로 리턴해도 된다.
			// 기존에는 문자열을 리턴하는 경우에 WEB-INF/movie/N.jsp 이런식으로 넘어갔었다.
			// 하지만 ajax 는 좀 다르다.
			// jsp에서도 out.print 를 썼지만 이때 브라우저에 출력하는 것이 아닌 호출한 ajax로 내보내는 역할을 했었다
			// 이와 마찬가지로 앞뒤로 붙이지말고 ajax로 넘기는 어노테이션이 있다.
			// @ResponseBody
		else
			//response.getWriter().append("Y");
			return "Y";
		
	}
}
