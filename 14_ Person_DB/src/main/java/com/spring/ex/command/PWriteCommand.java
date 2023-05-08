package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PWriteCommand implements PCommand{

	@Override
	public void execute(Model model) {
		// PController의 write()메서드에서 호출함.
		// Map 은 key, value 한쌍. 즉 model 을 Map처럼 사용하겠다는 의미다.
		Map<String, Object> map = model.asMap(); // 키. 값
		HttpServletRequest request = (HttpServletRequest)map.get("req"); // 컨트롤러에서 request 객체를 req에 담았음.
		
		System.out.println("PWriteCommand");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id + "/" + name + "/" + age + "\n");
		
		PDao pdao = PDao.getInstance();
		pdao.write(id, name, Integer.parseInt(age));
		// 삽입 작업 완료하면 다시 호출한 컨트롤러로 간다.
	}

}
