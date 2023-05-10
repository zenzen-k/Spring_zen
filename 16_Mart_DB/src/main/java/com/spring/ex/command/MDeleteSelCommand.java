package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;

public class MDeleteSelCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String[] selectDel = (String[])map.get("selectDel");
		
		for(String x : selectDel) {
			System.out.println(x + " ");
		}
		
		MartDao mdao = MartDao.getInstance();
		mdao.deleteSel(selectDel);
	}

}
