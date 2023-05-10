package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;
import com.spring.ex.dto.MartDto;

public class MUpdateFormCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String num = (String)map.get("num");
		MartDao mdao = MartDao.getInstance();
		MartDto martDto = mdao.getMartByNum(num);
		model.addAttribute("martDto", martDto);
	}

}
