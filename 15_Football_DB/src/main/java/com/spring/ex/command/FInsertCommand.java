package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FInsertCommand implements FCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		FDto fDto = (FDto)map.get("fDto");
		FDao fdao = FDao.getInstance();
		fdao.insertFootball(fDto);
	}
	
}
