package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;

public class MDeleteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String num = (String)map.get("num");
		// 다운캐스팅할때 만약에 int ㅕㅇㅆ으면 Integer 로 다운캐스팅 ㄱ
		MartDao mdao = MartDao.getInstance();
		mdao.delete(num);
	}

}
