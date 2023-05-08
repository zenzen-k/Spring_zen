package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PDeleteCommand implements PCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		PDao pdao = PDao.getInstance();
		pdao.deletePerson(request.getParameter("num"));
	}

}
