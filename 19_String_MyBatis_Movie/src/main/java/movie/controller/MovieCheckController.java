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
		
		if(result)  // �� : �����̹�����, ������
			//response.getWriter().append("N");
			return "N"; // ���ڿ��� �ٷ� �����ص� �ȴ�.
			// �������� ���ڿ��� �����ϴ� ��쿡 WEB-INF/movie/N.jsp �̷������� �Ѿ����.
			// ������ ajax �� �� �ٸ���.
			// jsp������ out.print �� ������ �̶� �������� ����ϴ� ���� �ƴ� ȣ���� ajax�� �������� ������ �߾���
			// �̿� ���������� �յڷ� ���������� ajax�� �ѱ�� ������̼��� �ִ�.
			// @ResponseBody
		else
			//response.getWriter().append("Y");
			return "Y";
		
	}
}
