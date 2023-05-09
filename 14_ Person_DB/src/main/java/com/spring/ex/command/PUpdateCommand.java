package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PUpdateCommand implements PCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		PDao pdao = PDao.getInstance();
		
		// 또는 여기서 request.getParameter 로 값을 하나씩 여기서 넣어서 보내도된다. 
		// (한묶음의 bean객체로 보내던가)
		pdao.updatePerson(request);
	}

}
